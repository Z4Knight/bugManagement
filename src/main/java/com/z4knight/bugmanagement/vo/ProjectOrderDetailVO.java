package com.z4knight.bugmanagement.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/25 15:08
 *
 * 工单管理-工单详情前端窗口展示类
 */

@Data
@JsonSerialize
public class ProjectOrderDetailVO {

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
