package com.z4knight.bugmanagement.form;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;


/**
 * @Author Z4knight
 * @Date 2018/1/8 14:52
 *
 * 前端请求接口，项目组提交表单数据
 */

@Data
@JsonSerialize
public class ProjectGroupForm {

    private String groupId;

    private String groupName;

    private String groupManager;

    private String note;

    private String register;

    private String modifier;

}
