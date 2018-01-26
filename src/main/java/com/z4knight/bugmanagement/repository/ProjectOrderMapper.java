package com.z4knight.bugmanagement.repository;

import com.z4knight.bugmanagement.dataobject.ProjectOrder;
import com.z4knight.bugmanagement.vo.ProjectOrderPaneVO;


import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/11 15:14
 * 
 * 工单-mapper接口
 */
public interface ProjectOrderMapper {

    List<ProjectOrderPaneVO> selectAll();

    void update(ProjectOrder order);

    ProjectOrder selectByOrderId(String orderId);

    void save(ProjectOrder order);

    void delete(String orderId);

    ProjectOrder selectByOrderName(String orderName);
}
