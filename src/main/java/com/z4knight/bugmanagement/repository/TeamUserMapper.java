package com.z4knight.bugmanagement.repository;

import com.z4knight.bugmanagement.dataobject.TeamUser;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/30 13:37
 * 
 * 小组用户-mapper接口
 */
public interface TeamUserMapper {

    List<TeamUser> selectAll();

    void update(TeamUser user);

    List<TeamUser> selectByOwnGroup(String ownGroup);

    void save(TeamUser user);

    int delete(List<String> userNames);

    TeamUser selectByUserName(String userName);
}
