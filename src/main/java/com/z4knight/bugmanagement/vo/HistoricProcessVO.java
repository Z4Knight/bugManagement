package com.z4knight.bugmanagement.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/2/1 13:58
 *
 * 流转记录前端展示类
 */

@Data
@JsonSerialize
public class HistoricProcessVO {

    private String taskName;

    private String createTime;

    private String procTime;

    private String procUser;

    private String procAssigner;

    private String procResult;

    private String procDesp;
}
