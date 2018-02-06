package com.z4knight.bugmanagement.service.impl;

import com.z4knight.bugmanagement.dataobject.ProjectGroup;
import com.z4knight.bugmanagement.dataobject.TeamUser;
import com.z4knight.bugmanagement.enums.ErrorMsg;
import com.z4knight.bugmanagement.enums.LoggerMsg;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.form.TeamUserForm;
import com.z4knight.bugmanagement.form.UserLoginForm;
import com.z4knight.bugmanagement.repository.TeamUserMapper;
import com.z4knight.bugmanagement.service.ProjectGroupService;
import com.z4knight.bugmanagement.service.TeamUserService;
import com.z4knight.bugmanagement.util.Entity2VoConvert;
import com.z4knight.bugmanagement.vo.TeamUserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/29 15:07
 */

@Slf4j
@Service
public class TeamUserServiceImpl implements TeamUserService {

    @Autowired
    private TeamUserMapper mapper;

    @Autowired
    private ProjectGroupService groupService;

    @Override
    public List<TeamUser> selectAll() {
        return null;
    }

    @Override
    public List<TeamUserVO> selectByOwnGroup(String ownGroup) {
       if (StringUtils.isEmpty(ownGroup)) {
           log.error(LoggerMsg.USER_MANAGER_QUERY_LIST.getMsg() + ", ErrorMsg={}", ErrorMsg.GROUP_NAME_REQUIRED.getMsg());
           throw new ServiceException(ErrorMsg.GROUP_NAME_REQUIRED.getMsg());
       }
        ProjectGroup group = groupService.selectByGroupName(ownGroup);
       if (group == null) {
           log.error(LoggerMsg.USER_MANAGER_QUERY_LIST.getMsg() + ", ErrorMsg={}", ErrorMsg.GROUP_NOT_EXIST.getMsg());
           throw new ServiceException(ErrorMsg.GROUP_NOT_EXIST.getMsg());
       }
       List<TeamUser> teamUserList = mapper.selectByOwnGroup(ownGroup);
       List<TeamUserVO> teamUserVOList = Entity2VoConvert.convertUser(teamUserList);
       log.info(LoggerMsg.USER_MANAGER_QUERY_LIST.getMsg() + ", list={}", teamUserVOList);
       return teamUserVOList;
    }

    @Transactional
    @Override
    public TeamUser save(TeamUserForm userForm) {

        return null;
    }

    @Transactional
    @Override
    public int delete(List<String> userNames) {
        if (userNames != null || userNames.size() > 0) {
            int result = mapper.delete(userNames);
            log.info(LoggerMsg.USER_MANAGER_DELETE.getMsg() + ", delete numbers={}", result);
            return result;
        } else {
            log.error(LoggerMsg.USER_MANAGER_DELETE.getMsg() + ", ErrorMsg={}",ErrorMsg.NO_MESSAGE_DELETED.getMsg());
            throw new ServiceException(ErrorMsg.NO_MESSAGE_DELETED.getMsg());
        }
    }

    @Transactional
    @Override
    public TeamUser update(TeamUser user) {
        return null;
    }

    @Override
    public TeamUser selectByUserName(String userName) {
        if (StringUtils.isEmpty(userName)) {
            log.error(LoggerMsg.USER_MANAGER_QUERY_POINT.getMsg() + ", ErrorMsg={}",ErrorMsg.USER_NAME_REQUIRED.getMsg());
            throw new ServiceException(ErrorMsg.USER_NAME_REQUIRED.getMsg());
        }
        TeamUser user = mapper.selectByUserName(userName);
        log.info(LoggerMsg.USER_MANAGER_QUERY_POINT.getMsg() + ", user={}", user);
        return user;
    }

    @Override
    public UserLoginForm checkUserInfo(UserLoginForm userLoginForm) {
        if (StringUtils.isEmpty(userLoginForm.getPassWord())) {
            log.error(LoggerMsg.USER_MANAGER_LOGIN.getMsg() + ", ErrorMsg={}",ErrorMsg.USER_PSWD_REQUIRED.getMsg());
            throw new ServiceException(ErrorMsg.USER_PSWD_REQUIRED.getMsg());
        }
        TeamUser user = selectByUserName(userLoginForm.getUserName());
        if (null == user || !userLoginForm.getPassWord().equals(user.getUserPswd())) {
            log.error(LoggerMsg.USER_MANAGER_LOGIN.getMsg() + ", ErrorMsg={}",ErrorMsg.USER_NAME_OR_PSWD_ERROR.getMsg());
            throw new ServiceException(ErrorMsg.USER_NAME_OR_PSWD_ERROR.getMsg());
        }
        log.info(LoggerMsg.USER_MANAGER_LOGIN.getMsg() + ", userName={}", user.getUserName());
        return userLoginForm;
    }
}
