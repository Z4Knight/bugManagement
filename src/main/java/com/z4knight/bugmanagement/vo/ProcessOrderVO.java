package com.z4knight.bugmanagement.vo;

import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/22 15:50
 */
@Data
public class ProcessOrderVO {

    private String taskName;

    private String orderId;

    private String orderName;

    private String handler;

    private String testManager;

    private String type;
}
