package com.z4knight.bugmanagement.vo;

import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/19 11:02
 *
 * 通用流转信息前端接口类
 */
@Data
public class GeneralProcessVO {

    private String objectType;

    private String objectId;

    private String taskName;

    private String objectName;

    private String procStatus;

}
