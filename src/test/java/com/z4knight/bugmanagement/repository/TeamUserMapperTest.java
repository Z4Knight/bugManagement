package com.z4knight.bugmanagement.repository;

import cn.lz.cloud.common.util.UUID;
import com.z4knight.bugmanagement.dataobject.TeamUser;
import com.z4knight.bugmanagement.util.DateUtil;
import com.z4knight.bugmanagement.vo.TeamUserVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author Z4knight
 * @Date 2018/1/30 14:08
 */


@SpringBootTest
@RunWith(SpringRunner.class)
public class TeamUserMapperTest {

    @Autowired
    private TeamUserMapper mapper;

    @Test
    public void update() throws Exception {
        TeamUser user = new TeamUser();
        user.setUserPswd("123");
        user.setOwnGroup("测试管理");
        user.setNickName("管理员0");
        user.setModifier("admin0");
        user.setEditTime(DateUtil.getCurrentTime());
        user.setUserName("admin0");
        user.setRole("管理员");
        mapper.update(user);
    }

    @Test
    public void selectByOwnGroup() throws Exception {
        List<TeamUser> teamUsers = mapper.selectByOwnGroup("测试管理");
        Assert.assertNotEquals(0, teamUsers.size());
    }

    @Test
    public void save() throws Exception {
        TeamUser user = new TeamUser();
        user.setUserPswd("123");
        user.setOwnGroup("测试管理");
        user.setNickName("tom猫");
        user.setRegister("admin");
        user.setModifier("admin");
        user.setCreateTime(DateUtil.getCurrentTime());
        user.setEditTime(DateUtil.getCurrentTime());
        user.setUuid(UUID.getUUID());
        user.setUserName("tom");
        user.setRole("测试人员");
        mapper.save(user);
    }

    @Test
    public void selectByUserName() throws Exception {
        TeamUser user = mapper.selectByUserName("admin");
        Assert.assertNotNull(user);
    }

}