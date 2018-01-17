package com.z4knight.bugmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.z4knight.bugmanagement.dataobject.ProjectOrder;
import com.z4knight.bugmanagement.enums.ErrorMsg;
import com.z4knight.bugmanagement.enums.ItemCode;
import com.z4knight.bugmanagement.enums.OrderState;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.form.ProjectOrderForm;
import com.z4knight.bugmanagement.repository.ProjectOrderMapper;
import com.z4knight.bugmanagement.service.ProjectOrderService;
import com.z4knight.bugmanagement.util.CodeGeneratorUtil;
import com.z4knight.bugmanagement.util.DateUtil;
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

@Service
public class ProjectOrderServiceImpl implements ProjectOrderService{
    
    @Autowired
    private ProjectOrderMapper mapper;

    @Override
    public List<ProjectOrder> selectAll(Integer page, Integer size) {
        // 起始页
        int startPage = page.intValue();
        // 每页显示多少条
        int pageRow = size.intValue();
        if (startPage == 0 && pageRow == 0) {
            List<ProjectOrder> orderList = mapper.selectAll();
            if (orderList != null && orderList.size() > 1000L) {
                throw new ServiceException(ErrorMsg.DATA_OVERFLOW.getMsg());
            }
        }
        PageHelper.startPage(startPage, pageRow);
        List<ProjectOrder> orderList = mapper.selectAll();
        PageInfo<ProjectOrder> orderPageInfo = new PageInfo<>(orderList);
        orderList = orderPageInfo.getList();
        if (null == orderList || orderList.size() == 0) {
            throw new ServiceException(ErrorMsg.DATA_NOT_EXIST.getMsg());
        }
        return orderList;
    }

    @Override
    public ProjectOrder save(ProjectOrderForm projectOrderForm) {
        ProjectOrder order = selectByOrderName(projectOrderForm.getOrderName());
        if (null != order) {
            throw new ServiceException(ErrorMsg.ORDER_NAME_EXIST.getMsg());
        }
        order = new ProjectOrder();
        // 设置来自于前端传送的接口信息
        BeanUtils.copyProperties(projectOrderForm, order);
        // 新的工单状态默认设置为：排期审批通过
        order.setState(OrderState.PASS_SCHEDULE_APPROVAL.getMsg());
        // 设置自动生成编码
        order.setOrderId(CodeGeneratorUtil.generateCode(ItemCode.ORDER));
        // 设置登记与修改日期为系统当前日期
        order.setCreateTime(DateUtil.getCurrentDate());
        order.setEditTime(DateUtil.getCurrentDate());
        mapper.save(order);
        return order;
    }

    @Override
    public ProjectOrder update(ProjectOrderForm projectOrderForm) {
        ProjectOrder result = selectByOrderName(projectOrderForm.getOrderName());
        if (null != result && !result.getOrderId().equals(projectOrderForm.getOrderId())) {
            throw new ServiceException(ErrorMsg.ORDER_NAME_EXIST.getMsg());
        }
        result = new ProjectOrder();
        ProjectOrder order = selectByOrderId(projectOrderForm.getOrderId());
        // 设置来自于前端传送的接口信息
        BeanUtils.copyProperties(projectOrderForm, result);
        // 设置其他原本存于数据库中的数据
        result.setState(order.getState());
        result.setCreateTime(order.getCreateTime());
        result.setEditTime(DateUtil.getCurrentDate());
        result.setRegister(order.getRegister());
        mapper.update(result);
        return result;
    }

    @Override
    public ProjectOrder selectByOrderId(String orderId) {
        if (StringUtils.isEmpty(orderId)) {
            throw new ServiceException(ErrorMsg.ORDER_CODE_REQUIRED.getMsg());
        }
        ProjectOrder order = mapper.selectByOrderId(orderId);
        if (null == order) {
            throw new ServiceException(ErrorMsg.DATA_NOT_EXIST.getMsg());
        }
        return order;
    }

    @Override
    public ProjectOrder selectByOrderName(String orderName) {
        if (StringUtils.isEmpty(orderName)) {
            throw new ServiceException(ErrorMsg.ORDER_NAME_REQUIRED.getMsg());
        }
        ProjectOrder order = mapper.selectByOrderName(orderName);
        return order;
    }

    @Override
    public void delete(String orderId) {
        if (StringUtils.isEmpty(orderId)) {
            throw new ServiceException(ErrorMsg.ORDER_CODE_REQUIRED.getMsg());
        }
        ProjectOrder order = selectByOrderId(orderId);
        if (null == order) {
            throw new ServiceException(ErrorMsg.DATA_NOT_EXIST.getMsg());
        }
        mapper.delete(orderId);
    }
}
