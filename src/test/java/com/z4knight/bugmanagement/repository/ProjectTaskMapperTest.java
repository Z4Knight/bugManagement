package com.z4knight.bugmanagement.repository;

import com.z4knight.bugmanagement.dataobject.ProjectTask;
import com.z4knight.bugmanagement.enums.ItemCode;
import com.z4knight.bugmanagement.enums.TaskState;
import com.z4knight.bugmanagement.util.CodeGeneratorUtil;
import com.z4knight.bugmanagement.util.DateUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author Z4knight
 * @Date 2018/1/17 16:04
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectTaskMapperTest {


    @Autowired
    private ProjectTaskMapper mapper;

    ProjectTask task = new ProjectTask();

    @Test
    @Before
    public void init() {
        task.setState(TaskState.NEW_TASK.getMsg());
        task.setWorkLoad("big");
        task.setType("测试执行");
        task.setTailor("否");
        task.setStartTime(DateUtil.getCurrentDate());
        task.setRegister("zk");
        task.setPriority("高");
        task.setPrincipal("ldl");
        task.setOwnSystem("test");
        task.setOwnOrder("testTest");
        task.setModifier("zk");
        task.setHandler("老铁");
        task.setEndTime(DateUtil.getCurrentDate());
        task.setEditTime(DateUtil.getCurrentDate());
        task.setDescription("testtestsetse");
        task.setCreateTime(DateUtil.getCurrentDate());
        task.setAutomation("否");
        task.setExecutor("z4kngiht");
        task.setTaskId(CodeGeneratorUtil.generateCode(ItemCode.TASK));
        task.setTaskName("测试test");
        task.setMileStone("否");
        task.setReviewer("小黑鬼");

    }
    
    @Test
    public void selectAll() throws Exception {
        List<ProjectTask> projectTasks = mapper.selectAll();
        Assert.assertNotEquals(0, projectTasks.size());
    }

    @Test
    public void update() throws Exception {
        task.setModifier("bsc");
        task.setState(TaskState.UNDER_REVIEW.getMsg());
        task.setTaskId("T000001");
        mapper.update(task);
    }

    @Test
    public void selectByTaskId() throws Exception {
        ProjectTask projectTask = mapper.selectByTaskId("T000001");
        Assert.assertNotNull(projectTask);
    }

    @Test
    public void save() throws Exception {
        mapper.save(task);
    }

    @Test
    public void delete() throws Exception {
        mapper.delete("T000001");
    }

    @Test
    public void selectByTaskName() throws Exception {
        ProjectTask task = mapper.selectByTaskName("测试test");
        Assert.assertNotNull(task);
    }

}