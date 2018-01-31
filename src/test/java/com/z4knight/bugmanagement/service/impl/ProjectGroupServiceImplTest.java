package com.z4knight.bugmanagement.service.impl;

import com.z4knight.bugmanagement.dataobject.ProjectGroup;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.form.ProjectGroupForm;
import com.z4knight.bugmanagement.vo.ProjectGroupVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author Z4knight
 * @Date 2018/1/8 14:00
 */


@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectGroupServiceImplTest {

    @Autowired
    private ProjectGroupServiceImpl projectGroupService;

    @Test
    public void selectAll() {
        List<ProjectGroupVO> groups = projectGroupService.selectAll(0,1);
        Assert.assertNotEquals(0, groups.size());

    }

    @Test
    public void selectByGroupId() {
        ProjectGroup group = projectGroupService.selectByGroupId("G000003");
        Assert.assertNotNull(group);
    }


    @Test
    public void save() {
        ProjectGroupForm projectGroupForm = new ProjectGroupForm();
        projectGroupForm.setGroupManager("小黑");
        projectGroupForm.setGroupName("测试管理");
        projectGroupForm.setNote("empty");
        ProjectGroup group = projectGroupService.save(projectGroupForm);
        Assert.assertNotNull(group);
    }


    @Test
    public void delete() {
        List<String> groupIds = new ArrayList<>();
        groupIds.add("G000002");
        groupIds.add("G000003");
        int result = projectGroupService.delete(groupIds);
        Assert.assertEquals(2, result);

    }
}