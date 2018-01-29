package com.z4knight.bugmanagement.form;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/29 13:43
 */

@JsonSerialize
@Data
public class UserLoginForm {

    private String userName;

    private String passWord;
}
