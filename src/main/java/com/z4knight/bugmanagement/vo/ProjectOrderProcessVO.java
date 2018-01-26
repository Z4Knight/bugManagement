package com.z4knight.bugmanagement.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/22 15:50
 *
 * 流程管理-工单概要信息前端展示类
 */
@Data
@JsonSerialize
public class ProjectOrderProcessVO {

    private String taskName;

    private String orderId;

    private String orderName;

    private String handler;

    private String testManager;

    private String type;

    private String degree;

    private String priority;

    private String principal;

    private String actTestOkDate;

    private String actUatDate;

    private String isJump;

    private String isNewProduct;

    private String ownSystem;

    private String foreWorkLoad;

    private String procUser;

    private String procResult;

    private String procAssigner;

    private String procDesp;

}
