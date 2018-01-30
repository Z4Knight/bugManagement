package com.z4knight.bugmanagement.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/30 10:01
 *
 * 被测系统前端展示类
 */

@Data
@JsonSerialize
public class TestSystemVO {

    private String systemId;

    private Boolean open;

    private String systemName;

    private String testDirector;

    private String devDirector;

    private String versionNumber;

    private String description;

    private String note;

    private String register;

    private String modifier;

    private String createTime;

    private String editTime;
}
