package com.z4knight.bugmanagement.dataobject;

import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/16 16:34
 *
 * 测试管理-任务实体类
 */

@Data
public class ProjectTask {

    private String taskId;

    private String taskName;

    private String description;

    private String state;

    private String type;

    private String priority;

    private String principal;

    private String executor;

    private String reviewer;

    private String handler;

    private String workLoad;

    private String mileStone;

    private String tailor;

    private String automation;

    private String ownOrder;

    private String ownSystem;

    private String startTime;

    private String endTime;

    private String register;

    private String modifier;

    private String createTime;

    private String editTime;
}
