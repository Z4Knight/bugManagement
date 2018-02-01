package com.z4knight.bugmanagement.form;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/12 11:21
 *
 * 前端请求接口，工单提交表单数据
 */

@Data
@JsonSerialize
public class ProjectOrderForm {

    private String orderId;

    private String orderName;

    private String description;

    private String type;

    private String priority;

    private String principal;

    private String testManager;

    private String devDirector;

    private String handler;

    private String devWorkLoad;

    private String devScale;

    private String ownSystem;

    private String testEnv;

    private String testRange;

    private String testSug;

    private String startTime;

    private String endTime;

}
