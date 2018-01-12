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

    private String workLoad;

    private String devScale;

    private String ownSystem;

    private String testEnv;

    private String testRange;

    private String testSug;

    private String startTime;

    private String endTime;

    private String register;

    private String modifier;

    private String createTime;

    private String editTime;
}
