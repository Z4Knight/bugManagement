package com.z4knight.bugmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.z4knight.bugmanagement.dataobject.GeneralProcess;
import com.z4knight.bugmanagement.dataobject.HistoricProcess;
import com.z4knight.bugmanagement.dataobject.ProjectOrder;
import com.z4knight.bugmanagement.enums.*;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.form.ProcessOrderForm;
import com.z4knight.bugmanagement.form.ProjectOrderForm;
import com.z4knight.bugmanagement.repository.ProjectOrderMapper;
import com.z4knight.bugmanagement.service.GeneralProcessService;
import com.z4knight.bugmanagement.service.HistoricProcessService;
import com.z4knight.bugmanagement.service.ProjectOrderService;
import com.z4knight.bugmanagement.util.CodeGeneratorUtil;
import com.z4knight.bugmanagement.util.DateUtil;
import com.z4knight.bugmanagement.vo.ProjectOrderDetailVO;
import com.z4knight.bugmanagement.vo.ProjectOrderPaneVO;
import com.z4knight.bugmanagement.vo.ProjectOrderProcessVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/12 11:29
 *
 * 工单-服务实现类
 */

@Slf4j
@Service
public class ProjectOrderServiceImpl implements ProjectOrderService{
    @Autowired
    private ProjectOrderMapper mapper;

    @Autowired
    private GeneralProcessService generalProcessService;


    @Autowired
    private HistoricProcessService historicProcessService;

    @Override
    public List<ProjectOrderPaneVO> selectAll(Integer page, Integer size) {
        // 起始页
        int startPage = page.intValue();
        // 每页显示多少条
        int pageRow = size.intValue();
        if (startPage == 0 && pageRow == 0) {
            List<ProjectOrderPaneVO> orderList = mapper.selectAll();
            if (orderList != null && orderList.size() > 1000L) {
                log.error(LoggerMsg.ORDER_MANAGER_QUERY_LIST.getMsg() + ", ErrorMsg={}", ErrorMsg.DATA_OVERFLOW.getMsg());
                throw new ServiceException(ErrorMsg.DATA_OVERFLOW.getMsg());
            }
        }
        PageHelper.startPage(startPage, pageRow);
        List<ProjectOrderPaneVO> orderList = mapper.selectAll();
        PageInfo<ProjectOrderPaneVO> orderPageInfo = new PageInfo<>(orderList);
        orderList = orderPageInfo.getList();
        if (null == orderList || orderList.size() == 0) {
            log.error(LoggerMsg.ORDER_MANAGER_QUERY_LIST.getMsg() + ", ErrorMsg={}", ErrorMsg.DATA_NOT_EXIST.getMsg());
            throw new ServiceException(ErrorMsg.DATA_NOT_EXIST.getMsg());
        }
        log.info(LoggerMsg.ORDER_MANAGER_QUERY_LIST.getMsg() + ", List={}", orderList);
        return orderList;
    }

    @Override
    public ProjectOrder save(ProjectOrderForm projectOrderForm) {
        ProjectOrder order = selectByOrderName(projectOrderForm.getOrderName());
        if (null != order) {
            log.error(LoggerMsg.ORDER_MANAGER_ADD.getMsg() + ", ErrorMsg={}", ErrorMsg.ORDER_NAME_EXIST.getMsg());
            throw new ServiceException(ErrorMsg.ORDER_NAME_EXIST.getMsg());
        }
        order = new ProjectOrder();
        // 设置来自于前端传送的接口信息
        BeanUtils.copyProperties(projectOrderForm, order);
        // 设置自动生成编码
        order.setOrderId(CodeGeneratorUtil.generateCode(ItemCode.ORDER));
        // 新的工单状态默认设置为：排期审批通过
        order.setState(OrderState.PASS_SCHEDULE_APPROVAL.getMsg());
        // 默认设置未提交uat测试
        order.setUatSubmit(GeneralMsg.NO.getMsg());
        // 默认设置未关闭
        order.setIsClosed(GeneralMsg.NO.getMsg());
        // 关闭类型
        order.setCloseType(OrderState.NOT_CLOSED.getMsg());
        // 默认设置不是新产品
        order.setIsNewProduct(GeneralMsg.NO.getMsg());
        // 默认设置未插队
        order.setIsJump(GeneralMsg.NO.getMsg());
        // 设置登记与修改日期为系统当前日期
        order.setCreateTime(DateUtil.getCurrentDate());
        order.setEditTime(DateUtil.getCurrentDate());
        log.info(LoggerMsg.ORDER_MANAGER_ADD.getMsg() + ", order={}", order);
        mapper.save(order);
        // 设置工单业务流程开始
        startProcess(order);
        // 保存工单创建流转记录
        storeOrderCreateProcess(order);
        return order;
    }

    @Override
    public ProjectOrderPaneVO updateToPane(ProjectOrderForm projectOrderForm) {
        return null;
    }

    @Override
    public ProjectOrderProcessVO updateToProfile(ProcessOrderForm processOrderForm) {
        return null;
    }

    @Override
    public ProjectOrderDetailVO selectByOrderIdToDetail(String orderId) {
        return null;
    }

    @Override
    public ProjectOrderProcessVO selectByOrderIdToProfile(String orderId) {
        return null;
    }

    private void storeOrderCreateProcess(ProjectOrder order) {
        HistoricProcess process = new HistoricProcess();
        process.setObjectId(order.getOrderId());
        process.setTaskName("工单新建");
        process.setProcTime(DateUtil.getCurrentTime());
        process.setProcAssigner(order.getHandler());
        process.setProcUser(order.getRegister());
        // 默认没有处理结论
        process.setProcResult(ProcCode.NOTHING.getMsg());
        historicProcessService.save(process);
    }



    private void startProcess(ProjectOrder order) {
        // 设置流转变量
        GeneralProcess process = new GeneralProcess();
        // 设置流程定义key
        String procDefKey = "wf_feedtest";
        // 默认登记、修改人与登记、修改时间与工单新建时相同
        process.setRegister(order.getRegister());
        process.setModifier(order.getModifier());
        process.setCreateTime(order.getCreateTime());
        process.setEditTime(order.getEditTime());
        // 绑定当前工单编码及名称并设置业务类型为工单
        process.setObjectId(order.getOrderId());
        process.setObjectName(order.getOrderName());
        process.setObjectType(ItemMsg.ORDER.getMsg());
        // 设置分派人和处理人为：工单当前处理人
        process.setProcAssigner(order.getHandler());
        process.setProcUser(order.getHandler());
        // 处理时间为当前工单创建时间
        process.setProcDate(order.getCreateTime());
        // 工单新建完成，处理结论默认设置为：无
        process.setProcResult(ProcCode.NOTHING.getMsg());
        // 工单新建完成，默认处理状态为：未处理
        process.setProcStatus(ProcStatus.UNTREATED.getMsg());
        generalProcessService.save(process, procDefKey);
    }

//    @Override
//    public ProjectOrderVO update(ProjectOrderForm projectOrderForm) {
//        ProjectOrderVO result = selectByOrderName(projectOrderForm.getOrderName());
//        // 判断工单名称是否重复
//        if (null != result && !result.getOrderId().equals(projectOrderForm.getOrderId())) {
//            throw new ServiceException(ErrorMsg.ORDER_NAME_EXIST.getMsg());
//        }
//        // 判断工单是否流转
//        if (null != generalProcessService.selectByObjectId(projectOrderForm.getOrderId())) {
//            throw new ServiceException(ErrorMsg.ORDER_HAS_FLOW_NOT_MODIFIY.getMsg());
//        }
//        result = new ProjectOrderVO();
//        ProjectOrderVO order = selectByOrderId(projectOrderForm.getOrderId());
//        // 设置来自于前端传送的接口信息
//        BeanUtils.copyProperties(projectOrderForm, result);
//        // 设置其他原本存于数据库中的数据
//        result.setState(order.getState());
//        result.setCreateTime(order.getCreateTime());
//        result.setEditTime(DateUtil.getCurrentDate());
//        result.setRegister(order.getRegister());
//        mapper.update(result);
//        return result;
//    }



    private ProjectOrder selectByOrderId(String orderId) {
        if (StringUtils.isEmpty(orderId)) {
            log.error(LoggerMsg.ORDER_MANAGER_QUERY_POINT.getMsg() + ", ErrorMsg={}", ErrorMsg.ORDER_CODE_REQUIRED.getMsg());
            throw new ServiceException(ErrorMsg.ORDER_CODE_REQUIRED.getMsg());
        }
        ProjectOrder order = mapper.selectByOrderId(orderId);
        if (null == order) {
            log.error(LoggerMsg.ORDER_MANAGER_QUERY_POINT.getMsg() + ", ErrorMsg={}", ErrorMsg.DATA_NOT_EXIST.getMsg());
            throw new ServiceException(ErrorMsg.DATA_NOT_EXIST.getMsg());
        }
        log.info(LoggerMsg.ORDER_MANAGER_QUERY_POINT.getMsg() + ", order={}", order);
        return order;
    }

    @Override
    public ProjectOrder selectByOrderName(String orderName) {
        if (StringUtils.isEmpty(orderName)) {
            log.error(LoggerMsg.ORDER_MANAGER_QUERY_POINT.getMsg() + ", ErrorMsg={}", ErrorMsg.ORDER_NAME_REQUIRED.getMsg());
            throw new ServiceException(ErrorMsg.ORDER_NAME_REQUIRED.getMsg());
        }
        ProjectOrder order = mapper.selectByOrderName(orderName);
        log.info(LoggerMsg.ORDER_MANAGER_QUERY_POINT.getMsg() + ", order={}", order);
        return order;
    }

    @Override
    public int delete(List<String> orderIds) {
        if (null != orderIds && orderIds.size() > 0) {

        } else {
            log.error(LoggerMsg.ORDER_MANAGER_DELETE.getMsg() + ", ErrorMsg={}", ErrorMsg.NO_MESSAGE_DELETED.getMsg());
            throw new ServiceException(ErrorMsg.NO_MESSAGE_DELETED.getMsg());
        }
        return 0;
    }



    private void deleteByOrderId(String orderId) {
        if (StringUtils.isEmpty(orderId)) {
            throw new ServiceException(ErrorMsg.ORDER_CODE_REQUIRED.getMsg());
        }
        // 判断工单是否流转
        if (null != generalProcessService.selectByObjectId(orderId)) {
            throw new ServiceException(ErrorMsg.ORDER_HAS_FLOW_NOT_DELETE.getMsg());
        }

        ProjectOrder order = selectByOrderId(orderId);
        if (null == order) {
            throw new ServiceException(ErrorMsg.DATA_NOT_EXIST.getMsg());
        }
        mapper.delete(orderId);
    }
}