package com.z4knight.bugmanagement.service;

import com.z4knight.bugmanagement.dataobject.GeneralProcess;
import com.z4knight.bugmanagement.form.ProcessOrderForm;
import com.z4knight.bugmanagement.vo.GeneralProcessVO;
import com.z4knight.bugmanagement.vo.ProjectOrderProcessVO;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/18 15:08
 *
 * 通用流转信息服务接口
 */

public interface GeneralProcessService {

//    List<GeneralProcess> selectAll();

    // 更新工单流转记录
    GeneralProcess updateOrder(ProcessOrderForm orderForm);

//    GeneralProcess updateTask()

    List<GeneralProcessVO> selectByProcAssigner(String procAssigner);

    ProjectOrderProcessVO selectByOrderIdToOrder(String orderId);


    GeneralProcess selectByObjectId(String objectId);

    GeneralProcess save(GeneralProcess process, String procDefKey);

//    GeneralProcess delete(String objectId);
}
