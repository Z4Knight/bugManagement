package com.z4knight.bugmanagement.form;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/16 17:13
 *
 * 前端请求接口，任务提交表单数据
 */

@Data
@JsonSerialize
public class ProjectTaskForm {

    private String taskId;

    private String taskName;

    private String description;

    private String type;

    private String priority;

    private String principal;

    private String executor;

    private String reviewer;

    private String handler;

    private String automation;

    private String ownOrder;

    private String ownSystem;

    private String startTime;

    private String endTime;

}
