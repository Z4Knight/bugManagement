package com.z4knight.bugmanagement.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/2/9 13:43
 *
 * 所属工单-前端面板展示类
 */

@Data
@JsonSerialize
public class ProjectOrderChatVO {

    private String orderId;

    private String orderName;

    private String state;

    private String type;

    private String priority;

    private String description;

}
