package com.z4knight.bugmanagement.repository;


import com.z4knight.bugmanagement.dataobject.ProjectGroup;
import com.z4knight.bugmanagement.enums.ItemCode;
import com.z4knight.bugmanagement.util.CodeGeneratorUtil;
import com.z4knight.bugmanagement.util.DateUtil;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @Author Z4knight
 * @Date 2018/1/5 16:57
 *
 * 测试类-测试 dao 层是否能准确完成功能
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectGroupMapperTest {

    @Autowired
    private ProjectGroupMapper mapper;


    @Test
    public void selectAll() {

    }


    @Test
    public void save() {
        ProjectGroup group = new ProjectGroup();
        group.setCreateTime(DateUtil.getCurrentDate());
        group.setEditTime(DateUtil.getCurrentDate());
        group.setGroupId("G000009");
        group.setGroupManager("zk");
        group.setGroupName("缺陷管理123");
        group.setModifier("zk");
        group.setNote("test");
        group.setOpen(0);
        group.setRegister("zk");
        mapper.save(group);
    }

    @Test
    public void update() {
        ProjectGroup group = new ProjectGroup();
        group.setCreateTime("2018-01-05");
        group.setEditTime(DateUtil.getCurrentDate());
        group.setGroupId("G000002");
        group.setGroupManager("mff");
        group.setGroupName("生活通");
        group.setModifier("zk");
        group.setNote("test789");
        group.setOpen(0);
        group.setRegister("ldl");
        mapper.update(group);
    }

    @Test
    public void selectByGroupId() {
        ProjectGroup group = mapper.selectByGroupId("G000002");
        Assert.assertNotNull(group);
    }

    @Test
    public void delete() {
        List<String> groupIds = new ArrayList<>();
        groupIds.add("G000006");
        int result = mapper.delete(groupIds);
        Assert.assertNotEquals(0, result);
    }

    @Test
    public void selectByGroupName() {
        ProjectGroup group = mapper.selectByGroupName("数人云");
        Assert.assertNotNull(group);
    }
}