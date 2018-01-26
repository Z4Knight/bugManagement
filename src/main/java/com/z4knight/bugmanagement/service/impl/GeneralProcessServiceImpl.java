package com.z4knight.bugmanagement.service.impl;


import cn.lz.cloud.common.util.UUID;
import com.z4knight.bugmanagement.dataobject.GeneralProcess;
import com.z4knight.bugmanagement.dataobject.HistoricProcess;
import com.z4knight.bugmanagement.enums.*;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.form.ProcessOrderForm;
import com.z4knight.bugmanagement.repository.GeneralProcessMapper;
import com.z4knight.bugmanagement.service.GeneralProcessService;
import com.z4knight.bugmanagement.service.HistoricProcessService;
import com.z4knight.bugmanagement.util.DateUtil;
import com.z4knight.bugmanagement.vo.GeneralProcessVO;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Z4knight
 * @Date 2018/1/18 15:09
 *
 * 通用流转信息服务实现类
 */
@Slf4j
@Service
public class GeneralProcessServiceImpl implements GeneralProcessService {

    @Autowired
    private GeneralProcessMapper mapper;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoricProcessService historicProcessService;



    @Override
    public List<GeneralProcess> selectAll() {
        List<GeneralProcess> generalProcessList = mapper.selectAll();
        if (null == generalProcessList || generalProcessList.size() == 0) {
            log.error(LoggerMsg.PROCESS_MANAGER_MSG_QUERY_LIST.getMsg() + ", ErrorMsg={}", ErrorMsg.DATA_NOT_EXIST.getMsg());
            throw new ServiceException(ErrorMsg.DATA_NOT_EXIST.getMsg());
        }
        log.info(LoggerMsg.PROCESS_MANAGER_MSG_QUERY_LIST.getMsg() + ", List={}", generalProcessList);
        return generalProcessList;
    }


    @Override
    public GeneralProcess update(ProcessOrderForm orderForm) {
        GeneralProcess result = new GeneralProcess();
        GeneralProcess generalProcess = completeTask(orderForm);
        BeanUtils.copyProperties(generalProcess, result);
        Task task = taskService.createTaskQuery()
                .executionId(generalProcess.getExecutionId())
                .singleResult();
        // 判断流程是否结束
        if (null == task) {
            storeOrderEndProcess(generalProcess);
            delete(generalProcess.getObjectId());
        } else {
            result.setProcDesp(orderForm.getProcDesp());
            result.setTaskName(task.getName());
            result.setTaskId(task.getId());
            result.setProcUser(orderForm.getProcAssigner());
            result.setProcStatus(ProcStatus.UNTREATED.getMsg());
            result.setProcAssigner(orderForm.getProcAssigner());
            result.setProcDate(DateUtil.getCurrentTime());
            result.setEditTime(DateUtil.getCurrentTime());
            result.setModifier(generalProcess.getProcAssigner());
            log.info(LoggerMsg.PROCESS_MANAGER_MSG_UPDATE.getMsg() + ", process={}", result);
            mapper.update(result);
            // 保存流转记录
            storeProcess(result);
        }

        return result;
    }

    private void storeOrderEndProcess(GeneralProcess generalProcess) {
        HistoricProcess process = new HistoricProcess();
        process.setObjectId(generalProcess.getObjectId());
        process.setProcTime(DateUtil.getCurrentTime());
        process.setTaskName("工单完结");
        process.setProcUser(generalProcess.getProcAssigner());
        process.setProcResult(ProcCode.NOTHING.getMsg());
        process.setProcDesp(generalProcess.getProcDesp());
        historicProcessService.save(process);
    }

    private GeneralProcess completeTask(ProcessOrderForm orderForm) {
        GeneralProcess generalProcess = selectByObjectId(orderForm.getOrderId());
        String taskID = generalProcess.getTaskId();
        Map<String, Object> variables = new HashMap<>();
        variables.put(ProcVal.RESULT.getVal(), orderForm.getProcResult());
        variables.put(ProcVal.ASSIGNER.getVal(), orderForm.getProcAssigner());
        // 设置流程变量，使用流程变量用来指定完成任务后，下一个连线
        taskService.complete(taskID, variables);
        // 更新流转记录
        updateProcessRecord(orderForm, generalProcess.getTaskId());
        return generalProcess;
    }

    private void updateProcessRecord(ProcessOrderForm orderForm, String taskId) {
        HistoricProcess process = new HistoricProcess();
        process.setProcDesp(orderForm.getProcDesp());
        process.setProcUser(orderForm.getProcUser());
        process.setProcResult(orderForm.getProcResult());
        process.setProcAssigner(orderForm.getProcAssigner());
        process.setTaskId(taskId);
        process.setObjectId(orderForm.getOrderId());
        process.setProcTime(DateUtil.getCurrentTime());
        historicProcessService.update(process);
    }

    @Override
    public GeneralProcess selectByObjectId(String objectId) {
        if (StringUtils.isEmpty(objectId)) {
            log.error(LoggerMsg.PROCESS_MANAGER_MSG_QUERY_POINT.getMsg() + ", ErrorMsg={}", ErrorMsg.DATA_NOT_EXIST.getMsg());
            throw new ServiceException(ErrorMsg.DATA_NOT_EXIST.getMsg());
        }
        return mapper.selectByObjectId(objectId);
    }

    @Override
    public List<GeneralProcessVO> selectByProcAssigner(String procAssigner) {
        if (StringUtils.isEmpty(procAssigner)) {
            log.error(LoggerMsg.PROCESS_MANAGER_MSG_QUERY_LIST.getMsg() + ", ErrorMsg={}", ErrorMsg.ASSIGNER_NOT_EXIST.getMsg());
            throw new ServiceException(ErrorMsg.ASSIGNER_NOT_EXIST.getMsg());
        }
        List<GeneralProcessVO> processList = mapper.selectByProcAssigner(procAssigner);
        if (null == processList || processList.size() == 0) {
            log.error(LoggerMsg.PROCESS_MANAGER_MSG_QUERY_LIST.getMsg() + ", ErrorMsg={}", ErrorMsg.CUR_ASSIGNER_HAS_NOT_FLOW_DATA.getMsg());
            throw new ServiceException(ErrorMsg.CUR_ASSIGNER_HAS_NOT_FLOW_DATA.getMsg());
        }
        log.info(LoggerMsg.PROCESS_MANAGER_MSG_QUERY_LIST.getMsg() + ", List={}", processList);
        return processList;
    }

    @Override
    public GeneralProcess save(GeneralProcess process, String procDefKey) {
        if (StringUtils.isEmpty(procDefKey)) {
            log.error(LoggerMsg.PROCESS_MANAGER_MSG_ADD.getMsg() + ", ErrorMsg={}", ErrorMsg.PRO_DEF_KEY_NOT_EXIST.getMsg());
            throw new ServiceException(ErrorMsg.PRO_DEF_KEY_NOT_EXIST.getMsg());
        }
        GeneralProcess result = new GeneralProcess();
        BeanUtils.copyProperties(process, result);
        // 设置唯一表示UUID
        result.setUuid(UUID.getUUID());
        Map<String, Object> variables = new HashMap<>();
        variables.put(ProcVal.ASSIGNER.getVal(), result.getProcAssigner());
        ProcessInstance pi = runtimeService.startProcessInstanceByKey(procDefKey, variables);
        Task task = taskService.createTaskQuery()
                .executionId(pi.getId())
                .singleResult();
        result.setExecutionId(task.getExecutionId());
        result.setProcDefId(pi.getProcessDefinitionId());
        result.setTaskId(task.getId());
        result.setProcInstId(pi.getId());
        result.setTaskName(task.getName());
        mapper.save(result);
        log.info(LoggerMsg.PROCESS_MANAGER_MSG_ADD.getMsg() + ", process={}", result);
        // 保存流转记录
        storeProcess(result);
        return result;
    }

    private void storeProcess(GeneralProcess result) {
        HistoricProcess process = new HistoricProcess();
        process.setTaskId(result.getTaskId());
        process.setObjectId(result.getObjectId());
        process.setTaskName(result.getTaskName());
        process.setProcUser(result.getProcUser());
        process.setProcResult(result.getProcResult());
        process.setProcDesp(result.getProcDesp());
        historicProcessService.save(process);
    }

    @Override
    public GeneralProcess delete(String objectId) {
        GeneralProcess process = selectByObjectId(objectId);
        log.info(LoggerMsg.PROCESS_MANAGER_MSG_DELETE.getMsg() + ", process={}", process);
        mapper.delete(objectId);
        return process;
    }
}
