package com.z4knight.bugmanagement.service;

import com.z4knight.bugmanagement.dataobject.ProjectOrder;
import com.z4knight.bugmanagement.form.ProjectOrderForm;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/12 11:19
 * 
 * 工单-服务类接口
 */
public interface ProjectOrderService {

    List<ProjectOrder> selectAll(Integer page, Integer size);

    ProjectOrder save(ProjectOrderForm projectOrderForm);

    ProjectOrder update(ProjectOrderForm projectOrderForm);

    ProjectOrder selectByOrderId(String orderId);

    ProjectOrder selectByOrderName(String orderName);

    void delete(String orderId);
}
