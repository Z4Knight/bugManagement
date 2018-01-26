package com.z4knight.bugmanagement.dataobject;

import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/11 15:07
 *
 * 测试管理-工单实体类
 */

@Data
public class ProjectOrder {

    private String orderId;

    private String orderName;

    private String description;

    private String state;

    private String type;

    private String priority;

    private String principal;

    private String testManager;

    private String devDirector;

    private String handler;

    private String degree;

    private String devWorkLoad;

    private String devScale;

    private String ownSystem;

    private String testEnv;

    private String testRange;

    private String testSug;

    private String foreWorkLoad;

    private String uatSubmit;

    private String uatDate;

    private String isClosed;

    private String closeType;

    private String closeDate;

    private String closeUser;

    private String closeDesp;

    private String isNewProduct;

    private String isJump;

    private String actTestOkDate;

    private String actUatDate;

    private String startTime;

    private String endTime;

    private String register;

    private String modifier;

    private String createTime;

    private String editTime;

    @Override
    public String toString() {
        return "ProjectOrder{" +
                "orderId='" + orderId + '\'' +
                ", orderName='" + orderName + '\'' +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", type='" + type + '\'' +
                ", priority='" + priority + '\'' +
                ", principal='" + principal + '\'' +
                ", testManager='" + testManager + '\'' +
                ", devDirector='" + devDirector + '\'' +
                ", handler='" + handler + '\'' +
                ", degree='" + degree + '\'' +
                ", devWorkLoad='" + devWorkLoad + '\'' +
                ", devScale='" + devScale + '\'' +
                ", ownSystem='" + ownSystem + '\'' +
                ", testEnv='" + testEnv + '\'' +
                ", testRange='" + testRange + '\'' +
                ", testSug='" + testSug + '\'' +
                ", foreWorkLoad='" + foreWorkLoad + '\'' +
                ", uatSubmit='" + uatSubmit + '\'' +
                ", uatDate='" + uatDate + '\'' +
                ", isClosed='" + isClosed + '\'' +
                ", closeType='" + closeType + '\'' +
                ", closeDate='" + closeDate + '\'' +
                ", closeUser='" + closeUser + '\'' +
                ", closeDesp='" + closeDesp + '\'' +
                ", isNewProduct='" + isNewProduct + '\'' +
                ", isJump='" + isJump + '\'' +
                ", actTestOkDate='" + actTestOkDate + '\'' +
                ", actUatDate='" + actUatDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", register='" + register + '\'' +
                ", modifier='" + modifier + '\'' +
                ", createTime='" + createTime + '\'' +
                ", editTime='" + editTime + '\'' +
                '}';
    }
}
