package com.z4knight.bugmanagement.service;

import com.z4knight.bugmanagement.form.UserLoginForm;

/**
 * @Author Z4knight
 * @Date 2018/1/29 15:05
 *
 * 用户管理-服务接口
 */
public interface UserManageService {

    UserLoginForm checkUserInfo(UserLoginForm userLoginForm);
}
