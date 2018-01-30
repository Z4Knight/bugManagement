package com.z4knight.bugmanagement.service;

import com.z4knight.bugmanagement.dataobject.TeamUser;
import com.z4knight.bugmanagement.form.TeamUserForm;
import com.z4knight.bugmanagement.form.UserLoginForm;
import com.z4knight.bugmanagement.vo.TeamUserVO;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/29 15:05
 *
 * 用户管理-服务接口
 */
public interface TeamUserService {

    List<TeamUser> selectAll();

    UserLoginForm checkUserInfo(UserLoginForm userLoginForm);

    List<TeamUserVO> selectByOwnGroup(String ownGroup);

    TeamUser save(TeamUserForm userForm);

    int delete(List<String> userNames);

    TeamUser update(TeamUser user);

    TeamUser selectByUserName(String userName);
}
