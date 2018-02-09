package com.z4knight.bugmanagement.service;

import com.z4knight.bugmanagement.dataobject.ProjectOrder;
import com.z4knight.bugmanagement.enums.OrderState;
import com.z4knight.bugmanagement.form.ProcessOrderForm;
import com.z4knight.bugmanagement.form.ProjectOrderForm;
import com.z4knight.bugmanagement.vo.ProjectOrderChatVO;
import com.z4knight.bugmanagement.vo.ProjectOrderProcessVO;
import com.z4knight.bugmanagement.vo.ProjectOrderDetailVO;
import com.z4knight.bugmanagement.vo.ProjectOrderPaneVO;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/12 11:19
 * 
 * 工单-服务类接口
 */
public interface ProjectOrderService {

    List<ProjectOrderPaneVO> selectAll(Integer page, Integer size);

    ProjectOrder save(ProjectOrderForm projectOrderForm);

    // 工单管理修改接口
    ProjectOrderPaneVO updateToPane(ProjectOrderForm projectOrderForm);

    // 流程管理修改接口
    ProjectOrderProcessVO updateToProfile(ProcessOrderForm processOrderForm, OrderState notClosed);

    ProjectOrderDetailVO selectByOrderIdToDetail(String orderId);

    ProjectOrderProcessVO selectByOrderIdToProfile(String orderId);

    ProjectOrder selectByOrderName(String orderName);

    int delete(List<String> orderIds);

    List<ProjectOrderChatVO> selectAll();
}
