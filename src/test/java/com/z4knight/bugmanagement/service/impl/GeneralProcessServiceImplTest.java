package com.z4knight.bugmanagement.service.impl;

import com.z4knight.bugmanagement.enums.GeneralMsg;
import com.z4knight.bugmanagement.enums.ProcCode;
import com.z4knight.bugmanagement.enums.ProcVal;
import com.z4knight.bugmanagement.form.ProcessOrderForm;
import com.z4knight.bugmanagement.service.GeneralProcessService;
import com.z4knight.bugmanagement.service.ProjectOrderService;
import com.z4knight.bugmanagement.vo.GeneralProcessVO;
import com.z4knight.bugmanagement.vo.ProjectOrderProcessVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author Z4knight
 * @Date 2018/1/26 14:13
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class GeneralProcessServiceImplTest {

    @Autowired
    private GeneralProcessService generalProcessService;



    // 处理当前流转信息
    @Test
    public void updateOrder() throws Exception {
        ProcessOrderForm orderForm = new ProcessOrderForm();
        ProjectOrderProcessVO projectOrderProcessVO = generalProcessService.selectByOrderIdToOrder("PRJ_000001");
        BeanUtils.copyProperties(projectOrderProcessVO, orderForm);
        orderForm.setProcAssigner("test1");
        orderForm.setProcResult(ProcCode.NO_PASS.getMsg());
        orderForm.setProcDesp("no");
//        orderForm.setForeWorkLoad("挺大的");
//        orderForm.setIsJump(GeneralMsg.YES.getMsg());
//        orderForm.setDegree("紧急");
        generalProcessService.updateOrder(orderForm);
    }

    // 列出当前用户的待办事项
    @Test
    public void list() throws Exception {
        String user = "byw";
        List<GeneralProcessVO> processVOList = generalProcessService.selectByProcAssigner(user);
        Assert.assertNotEquals(0,processVOList.size());
    }

    // 查询当前流转信息的详细信息
    @Test
    public void selectByObjectIdToOrder() throws Exception {
        ProjectOrderProcessVO projectOrderProcessVO = generalProcessService.selectByOrderIdToOrder("PRJ_000001");
        Assert.assertNotNull(projectOrderProcessVO);
    }
}