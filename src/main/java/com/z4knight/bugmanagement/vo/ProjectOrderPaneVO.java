package com.z4knight.bugmanagement.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/25 13:20
 *
 * 工单管理-前端面板展示类
 */

@Data
@JsonSerialize
public class ProjectOrderPaneVO {

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

    private String devWorkLoad;

    private String ownSystem;

    private String testEnv;

    private String testRange;

    private String testSug;

    private String register;

    private String modifier;

    private String createTime;

    private String editTime;
}
