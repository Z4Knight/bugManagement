package com.z4knight.bugmanagement.form;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/30 15:24
 *
 * 前端请求接口，增加用户表单数据
 */

@Data
@JsonSerialize
public class TeamUserForm {

    private String nickName;

    private String userName;

    private String role;

    private String ownGroup;

    private String idNumber;

    private String email;

    private String mobile;
}
