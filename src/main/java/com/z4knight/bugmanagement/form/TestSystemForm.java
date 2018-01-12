package com.z4knight.bugmanagement.form;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/10 16:30
 *
 * 前端请求接口，被测系统提交表单数据
 */

@Data
@JsonSerialize
public class TestSystemForm {

    private String systemId;

    private String systemName;

    private String testDirector;

    private String devDirector;

    private String versionNumber;

    private String description;

    private String note;

    private String register;

    private String modifier;
}
