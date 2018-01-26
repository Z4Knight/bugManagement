package com.z4knight.bugmanagement.form;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/22 15:41
 *
 * 前端请求接口，通用流转工单提交表单数据
 */

@JsonSerialize
@Data
public class ProcessOrderForm {

    private String orderId;

    private String orderName;

    private String principal;

    private String testManager;

    private String type;

    private String degree;

    private String priority;

    private String actTestOkDate;

    private String actUatDate;

    private String isJump;

    private String isNewProduct;

    private String ownSystem;

    private String foreWorkLoad;

    private String procUser;

    private String procResult;

    private String procDesp;

    private String procAssigner;


}
