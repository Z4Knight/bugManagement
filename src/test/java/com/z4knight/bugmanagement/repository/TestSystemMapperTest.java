package com.z4knight.bugmanagement.repository;

import com.z4knight.bugmanagement.dataobject.TestSystem;
import com.z4knight.bugmanagement.enums.ItemCode;
import com.z4knight.bugmanagement.enums.OpenCode;
import com.z4knight.bugmanagement.util.CodeGeneratorUtil;
import com.z4knight.bugmanagement.util.DateUtil;
import org.junit.After;
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
 * @Date 2018/1/10 15:41
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSystemMapperTest {

    @Autowired
    private TestSystemMapper mapper;

    @Test
    public void selectAll() throws Exception {
        List<TestSystem> system = mapper.selectAll();
        Assert.assertNotNull(system);
    }

    @Test
    public void update() throws Exception {
        TestSystem system = new TestSystem();
        system.setCreateTime(DateUtil.getCurrentDate());
        system.setDescription("t");
        system.setDevDirector("tom");
        system.setEditTime(DateUtil.getCurrentDate());
        system.setModifier("tom");
        system.setNote("");
        system.setOpen(OpenCode.OPEN.code());
        system.setRegister("tom");
        system.setSystemId(CodeGeneratorUtil.generateCode(ItemCode.SYSTEM));
        system.setSystemName("test1");
        system.setTestDirector("胖哥");
        system.setVersionNumber("v2.0");
        mapper.update(system);
    }

    @Test
    public void selectBySystemId() throws Exception {
        TestSystem system = mapper.selectBySystemId("S000001");
        Assert.assertNotNull(system);
    }

    @Test
    public void save() throws Exception {
        TestSystem system = new TestSystem();
        system.setCreateTime(DateUtil.getCurrentDate());
        system.setDescription("t");
        system.setDevDirector("tom");
        system.setEditTime(DateUtil.getCurrentDate());
        system.setModifier("tom");
        system.setNote("");
        system.setOpen(OpenCode.OPEN.code());
        system.setRegister("tom");
        system.setSystemId(CodeGeneratorUtil.generateCode(ItemCode.SYSTEM));
        system.setSystemName("test");
        system.setTestDirector("胖哥");
        system.setVersionNumber("v1.0");
        mapper.save(system);
    }

    @Test
    public void delete() throws Exception {
//        mapper.delete("S000001");
    }

    @Test
    public void selectBySystemName() throws Exception {
        TestSystem system = mapper.selectBySystemName("test");
        Assert.assertNotNull(system);
    }

}