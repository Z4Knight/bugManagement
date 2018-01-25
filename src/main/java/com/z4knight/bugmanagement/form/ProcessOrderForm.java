package com.z4knight.bugmanagement.form;

import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/22 15:41
 *
 * 前端请求接口，通用流转工单提交表单数据
 */

@Data
public class ProcessOrderForm {

    private String orderId;

    private String workLoad;

    private String priority;

    private String procUser;

    private String procResult;

    private String procDesp;

    private String procAssigner;


}
