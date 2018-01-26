package com.z4knight.bugmanagement.service.impl;

import com.z4knight.bugmanagement.dataobject.ProjectOrder;
import com.z4knight.bugmanagement.enums.GeneralMsg;
import com.z4knight.bugmanagement.enums.OrderState;
import com.z4knight.bugmanagement.enums.ProcCode;
import com.z4knight.bugmanagement.form.ProcessOrderForm;
import com.z4knight.bugmanagement.form.ProjectOrderForm;
import com.z4knight.bugmanagement.service.ProjectOrderService;
import com.z4knight.bugmanagement.util.DateUtil;
import com.z4knight.bugmanagement.vo.ProjectOrderDetailVO;
import com.z4knight.bugmanagement.vo.ProjectOrderPaneVO;
import com.z4knight.bugmanagement.vo.ProjectOrderProcessVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/26 9:40
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectOrderServiceImplTest {

    @Autowired
    private ProjectOrderService projectOrderService;

    @Test
    public void selectAll() throws Exception {
        List<ProjectOrderPaneVO> projectOrderPaneVOList = projectOrderService.selectAll(0, 10);
        Assert.assertNotEquals(0, projectOrderPaneVOList.size());
    }

    @Test
    public void save() throws Exception {
        ProjectOrderForm orderForm = new ProjectOrderForm();
        orderForm.setType("功能测试");
        orderForm.setTestSug("f");
        orderForm.setTestRange("f");
        orderForm.setTestManager("zl");
        orderForm.setTestEnv("ff");
        orderForm.setStartTime(DateUtil.getCurrentTime());
        orderForm.setRegister("zk");
        orderForm.setPriority("high");
        orderForm.setPrincipal("ldl");
        orderForm.setOwnSystem("test");
        orderForm.setOrderName("测试流转1");
        orderForm.setHandler("bsc");
        orderForm.setEndTime(DateUtil.getCurrentTime());
        orderForm.setDevWorkLoad("big");
        orderForm.setDevScale("for aa");
        orderForm.setDevDirector("小黑鬼");
        orderForm.setDescription("test");
        orderForm.setModifier("zk");
        ProjectOrder order = projectOrderService.save(orderForm);
        Assert.assertNotNull(order);
    }

    @Test
    public void updateToPane() throws Exception {
        ProjectOrderForm orderForm = new ProjectOrderForm();
        orderForm.setOrderId("PRJ_000001");
        orderForm.setType("dd");
        orderForm.setStartTime(DateUtil.getCurrentTime());
        orderForm.setPriority("low");
        orderForm.setPrincipal("你");
        orderForm.setOwnSystem("test1");
        orderForm.setOrderName("测试新接口修改");
        orderForm.setHandler("zkkkk");
        orderForm.setEndTime(DateUtil.getCurrentTime());
        orderForm.setDevWorkLoad("112");
        orderForm.setDevScale("5555");
        orderForm.setDevDirector("iiiii");
        orderForm.setDescription("testttttt");
        orderForm.setModifier("啦啦啦");
        ProjectOrderPaneVO projectOrderPaneVO = projectOrderService.updateToPane(orderForm);
        Assert.assertNotNull(projectOrderPaneVO);
    }

    @Test
    public void updateToProfile() throws Exception {
        ProcessOrderForm processOrderForm = new ProcessOrderForm();
        processOrderForm.setType("功能测试");
        processOrderForm.setTestManager("bsc");
        processOrderForm.setProcUser("zk");
        processOrderForm.setProcResult(ProcCode.PASS.getMsg());
        processOrderForm.setProcDesp("wu");
        processOrderForm.setProcAssigner("zk");
        processOrderForm.setPriority("low");
        processOrderForm.setPrincipal("瞎子");
        processOrderForm.setOwnSystem("test1");
        processOrderForm.setOrderName("测试新接口流程");
        processOrderForm.setOrderId("PRJ_000001");
        processOrderForm.setIsNewProduct(GeneralMsg.YES.getMsg());
        processOrderForm.setIsJump(GeneralMsg.YES.getMsg());
        processOrderForm.setDegree("紧急");
        processOrderForm.setActUatDate(DateUtil.getCurrentTime());
        processOrderForm.setActTestOkDate(DateUtil.getCurrentTime());
        ProjectOrderProcessVO projectOrderProcessVO = projectOrderService.updateToProfile(processOrderForm, OrderState.NOT_CLOSED);
        Assert.assertNotNull(projectOrderProcessVO);
    }

    @Test
    public void selectByOrderIdToDetail() throws Exception {
        ProjectOrderDetailVO orderDetailVO = projectOrderService.selectByOrderIdToDetail("PRJ_000001");
        Assert.assertNotNull(orderDetailVO);
    }

    @Test
    public void selectByOrderIdToProfile() throws Exception {
        ProjectOrderProcessVO orderProcessVO = projectOrderService.selectByOrderIdToProfile("PRJ_000001");
        Assert.assertNotNull(orderProcessVO);
    }

    @Test
    public void selectByOrderName() throws Exception {
        ProjectOrder order = projectOrderService.selectByOrderName("测试新接口");
        Assert.assertNotNull(order);
    }

    @Test
    public void delete() throws Exception {
        List<String> orderIds = new ArrayList<>();
        orderIds.add("PRJ_000002");
        orderIds.add("PRJ_000003");
        int delete = projectOrderService.delete(orderIds);
        Assert.assertEquals(2, delete);

    }

}