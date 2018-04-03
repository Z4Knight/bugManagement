package com.z4knight.bugmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.z4knight.bugmanagement.dataobject.GeneralProcess;
import com.z4knight.bugmanagement.dataobject.HistoricProcess;
import com.z4knight.bugmanagement.dataobject.ProjectOrder;
import com.z4knight.bugmanagement.dataobject.ProjectTask;
import com.z4knight.bugmanagement.enums.*;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.form.ProjectTaskForm;
import com.z4knight.bugmanagement.repository.ProjectTaskMapper;
import com.z4knight.bugmanagement.security.JwtUtil;
import com.z4knight.bugmanagement.service.GeneralProcessService;
import com.z4knight.bugmanagement.service.HistoricProcessService;
import com.z4knight.bugmanagement.service.ProjectOrderService;
import com.z4knight.bugmanagement.service.ProjectTaskService;
import com.z4knight.bugmanagement.util.CodeGeneratorUtil;
import com.z4knight.bugmanagement.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/17 16:28
 * 
 * 任务-服务实现类
 */

@Slf4j
@Service
public class ProjectTaskServiceImpl implements ProjectTaskService {

    @Autowired
    private ProjectTaskMapper mapper;

    @Autowired
    private ProjectOrderService orderService;

    @Autowired
    private GeneralProcessService generalProcessService;


    @Autowired
    private HistoricProcessService historicProcessService;

    @Override
    public List<ProjectTask> selectAll(Integer page, Integer size) {
        // 起始页
        int startPage = page.intValue();
        // 每页显示多少条
        int pageRow = size.intValue();
        if (startPage == 0 && pageRow == 0) {
            List<ProjectTask> taskList = mapper.selectAll();
            if (taskList != null && taskList.size() > 1000L) {
                log.error(LoggerMsg.TASK_MANAGER_QUERY_LIST.getMsg() + ", ErrorMsg={}", ErrorMsg.DATA_OVERFLOW.getMsg());
                throw new ServiceException(ErrorMsg.DATA_OVERFLOW.getMsg());
            }
        }
        PageHelper.startPage(startPage, pageRow);
        List<ProjectTask> taskList = mapper.selectAll();
        PageInfo<ProjectTask> taskPageInfo = new PageInfo<>(taskList);
        taskList = taskPageInfo.getList();
        if (null == taskList || taskList.size() == 0) {
            log.error(LoggerMsg.TASK_MANAGER_QUERY_LIST.getMsg() + ", ErrorMsg={}", ErrorMsg.DATA_NOT_EXIST.getMsg());
            throw new ServiceException(ErrorMsg.DATA_NOT_EXIST.getMsg());
        }
        log.info(LoggerMsg.TASK_MANAGER_QUERY_LIST.getMsg() + ", List={}", taskList);
        return taskList;
    }

    @Override
    public ProjectTask save(ProjectTaskForm projectTaskForm) {
        ProjectTask task = selectByTaskName(projectTaskForm.getTaskName());
        if (null != task) {
            log.error(LoggerMsg.TASK_MANAGER_ADD.getMsg() + ", ErrorMsg={}", ErrorMsg.TASK_NAME_EXIST.getMsg());
            throw new ServiceException(ErrorMsg.TASK_NAME_EXIST.getMsg());
        }
        task = new ProjectTask();
        // 设置来自于前端传送的接口信息
        BeanUtils.copyProperties(projectTaskForm, task);
        // 新任务状态默认设置为：新建
        task.setState(TaskState.NEW_TASK.getMsg());
        // 工作量来自于所属工单
        ProjectOrder order = orderService.selectByOrderName(projectTaskForm.getOwnOrder());
        if (null == order) {
            log.error(LoggerMsg.TASK_MANAGER_ADD.getMsg() + ", ErrorMsg={}", ErrorMsg.OWN_ORDER_NOT_EXIST.getMsg());
            throw new ServiceException(ErrorMsg.OWN_ORDER_NOT_EXIST.getMsg());
        }
        task.setWorkLoad(order.getDevWorkLoad());
        // 新任务是否里程碑默认为：否
        task.setMileStone("否");
        // 新任务是否可裁剪默认为：否
        task.setTailor("否");
        // 设置自动生成编码
        task.setTaskId(CodeGeneratorUtil.generateCode(ItemCode.TASK));
        // 设置登记与修改日期为系统当前日期
        task.setCreateTime(DateUtil.getCurrentDate());
        task.setEditTime(DateUtil.getCurrentDate());
        // 设置登记人与修改人为当前登录用户
        task.setRegister(JwtUtil.getCurrentUserName());
        task.setModifier(JwtUtil.getCurrentUserName());
        log.info(LoggerMsg.TASK_MANAGER_ADD.getMsg() + ", task={}", task);
        mapper.save(task);
        // 设置任务业务流程开始
//        startProcess(task);
        // 保存任务创建流转记录
//        storeTaskCreateProcess(task);
        return task;
    }

    private void storeTaskCreateProcess(ProjectTask task) {
        HistoricProcess process = new HistoricProcess();
        process.setObjectId(task.getTaskId());
        process.setTaskName("任务新建");
        process.setProcTime(DateUtil.getCurrentTime());
        process.setProcAssigner(task.getHandler());
        process.setProcUser(task.getRegister());
        // 默认没有处理结论
        process.setProcResult(ProcCode.NOTHING.getMsg());
        historicProcessService.save(process);
    }



    private void startProcess(ProjectTask task) {
        // 设置流转变量
        GeneralProcess process = new GeneralProcess();
        // 设置流程定义key
        String procDefKey = "wf_feedtest_task";
        // 默认登记、修改人与登记、修改时间与任务新建时相同
        process.setRegister(task.getRegister());
        process.setModifier(task.getModifier());
        process.setCreateTime(task.getCreateTime());
        process.setEditTime(task.getEditTime());
        // 绑定当前任务编码及名称并设置业务类型为任务
        process.setObjectId(task.getTaskId());
        process.setObjectName(task.getTaskName());
        process.setObjectType(ProcessBusMsg.TASK.getMsg());
        // 设置分派人和处理人为：任务当前处理人
        process.setProcAssigner(task.getHandler());
        process.setProcUser(task.getHandler());
        // 处理时间为当前任务创建时间
        process.setProcDate(task.getCreateTime());
        // 任务新建完成，处理结论默认设置为：无
        process.setProcResult(ProcCode.NOTHING.getMsg());
        // 任务新建完成，默认处理状态为：任务的类型
        process.setProcStatus(task.getType());
        generalProcessService.save(process, procDefKey);
    }

    @Override
    public ProjectTask update(ProjectTaskForm projectTaskForm) {
        ProjectTask result = selectByTaskName(projectTaskForm.getTaskName());
        if (null != result && !result.getTaskId().equals(projectTaskForm.getTaskId())) {
            throw new ServiceException(ErrorMsg.TASK_NAME_EXIST.getMsg());
        }
        result = new ProjectTask();
        ProjectTask task = selectByTaskId(projectTaskForm.getTaskId());
        // 设置来自于前端传送的接口信息
        BeanUtils.copyProperties(projectTaskForm, result);
        // 设置其他原本存于数据库中的数据
        result.setState(task.getState());
        result.setMileStone(task.getMileStone());
        result.setReviewer(task.getReviewer());
        result.setWorkLoad(task.getWorkLoad());
        result.setTailor(task.getTailor());
        result.setOwnOrder(task.getOwnOrder());
        result.setCreateTime(task.getCreateTime());
        result.setEditTime(DateUtil.getCurrentDate());
        result.setRegister(task.getRegister());
        mapper.update(result);
        return result;
    }

    @Override
    public ProjectTask selectByTaskId(String taskId) {
        if (StringUtils.isEmpty(taskId)) {
            throw new ServiceException(ErrorMsg.TASK_CODE_REQUIRED.getMsg());
        }
        ProjectTask task = mapper.selectByTaskId(taskId);
        if (null == task) {
            throw new ServiceException(ErrorMsg.DATA_NOT_EXIST.getMsg());
        }
        return task;
    }

    @Override
    public ProjectTask selectByTaskName(String taskName) {
        if (StringUtils.isEmpty(taskName)) {
            throw new ServiceException(ErrorMsg.TASK_NAME_REQUIRED.getMsg());
        }
        ProjectTask task = mapper.selectByTaskName(taskName);
        return task;
    }

    @Override
    public void delete(String taskId) {
        if (StringUtils.isEmpty(taskId)) {
            throw new ServiceException(ErrorMsg.TASK_CODE_REQUIRED.getMsg());
        }
        ProjectTask task = selectByTaskId(taskId);
        if (null == task) {
            throw new ServiceException(ErrorMsg.DATA_NOT_EXIST.getMsg());
        }
        mapper.delete(taskId);
    }
}
