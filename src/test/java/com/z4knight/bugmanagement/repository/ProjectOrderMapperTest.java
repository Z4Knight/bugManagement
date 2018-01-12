package com.z4knight.bugmanagement.repository;

import com.z4knight.bugmanagement.dataobject.ProjectOrder;
import com.z4knight.bugmanagement.enums.ItemCode;
import com.z4knight.bugmanagement.util.CodeGeneratorUtil;
import com.z4knight.bugmanagement.util.DateUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author Z4knight
 * @Date 2018/1/11 15:40
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectOrderMapperTest {

    ProjectOrder order = new ProjectOrder();

    @Test
    @Before
    public void init() {
        order.setCreateTime(DateUtil.getCurrentDate());
        order.setDescription("d");
        order.setDevDirector("a");
        order.setDevScale("10");
        order.setEditTime(DateUtil.getCurrentDate());
        order.setHandler("zk");
        order.setModifier("zk");
        order.setOrderId(CodeGeneratorUtil.generateCode(ItemCode.ORDER));
        order.setEndTime(DateUtil.getCurrentDate());
        order.setOrderName("test");
        order.setOwnSystem("test");
        order.setPrincipal("zdf");
        order.setPriority("G");
        order.setRegister("zk");
        order.setWorkLoad("big");
        order.setType("pass");
        order.setTestSug("");
        order.setTestRange("ervy");
        order.setTestManager("ldl");
        order.setTestEnv("");
        order.setState("pass");
        order.setStartTime(DateUtil.getCurrentDate());

    }

    @Autowired
    private ProjectOrderMapper mapper;

    @Test
    public void selectAll() throws Exception {
        List<ProjectOrder> orders = mapper.selectAll();
        Assert.assertEquals(1, orders.size());
    }

    @Test
    public void update() throws Exception {
        order.setEditTime(DateUtil.getCurrentDate());
        order.setModifier("ldl");
        mapper.update(order);
    }

    @Test
    public void selectByOrderId() throws Exception {
        ProjectOrder order = mapper.selectByOrderId("P000001");
        Assert.assertNotNull(order);
    }

    @Test
    public void save() throws Exception {
        mapper.save(order);
    }

    @Test
    public void delete() throws Exception {
        mapper.delete("P000001");
    }

    @Test
    public void selectByOrderName() throws Exception {
        ProjectOrder order = mapper.selectByOrderName("test");
        Assert.assertNotNull(order);
    }

}