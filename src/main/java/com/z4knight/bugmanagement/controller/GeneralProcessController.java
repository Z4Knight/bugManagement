package com.z4knight.bugmanagement.controller;

/**
 * @Author Z4knight
 * @Date 2018/1/26 14:08
 *
 * 通用流转控制类
 */

import com.z4knight.bugmanagement.dataobject.GeneralProcess;
import com.z4knight.bugmanagement.enums.ProcessBusMsg;
import com.z4knight.bugmanagement.form.ProcessForm;
import com.z4knight.bugmanagement.form.ProcessOrderForm;
import com.z4knight.bugmanagement.param.GeneralProcessFilter;
import com.z4knight.bugmanagement.param.ProcessOrderFilter;
import com.z4knight.bugmanagement.resultVO.Result;
import com.z4knight.bugmanagement.resultVO.ResultGenerator;
import com.z4knight.bugmanagement.security.JwtUtil;
import com.z4knight.bugmanagement.service.GeneralProcessService;
import com.z4knight.bugmanagement.service.HistoricProcessService;
import com.z4knight.bugmanagement.vo.GeneralProcessVO;
import com.z4knight.bugmanagement.vo.ProjectOrderProcessVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processManagement")
public class GeneralProcessController {


    @Autowired
    private GeneralProcessService generalProcessService;


    @GetMapping("/list")
    public Result list() {
        try {
            // 得到当前用户登录名
            String curUserName = JwtUtil.getCurrentUserName();
            List<GeneralProcessVO> generalProcessVOS = generalProcessService.selectByProcAssigner(curUserName);
            return ResultGenerator.genSuccessResult(generalProcessVOS);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PostMapping("/selectByObject")
    public Result selectByObject(@RequestBody ProcessForm processForm) {
        try {
            GeneralProcessFilter.valid(processForm);
            // 判断业务类型
            if (ProcessBusMsg.ORDER.getMsg().equals(processForm.getObjectType())) {
                ProjectOrderProcessVO projectOrderProcessVO = generalProcessService.selectByOrderIdToOrder(processForm.getObjectId());
                return ResultGenerator.genSuccessResult(projectOrderProcessVO);
            } else if (ProcessBusMsg.TASK.getMsg().equals(processForm.getObjectType())) {

                return ResultGenerator.genSuccessResult();
            } else {
                return ResultGenerator.genSuccessResult();
            }
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PostMapping("/updateOrder")
    public Result updateOrder(@RequestBody ProcessOrderForm orderForm) {
        try {
            ProcessOrderFilter.valid(orderForm);
            GeneralProcess process = generalProcessService.updateOrder(orderForm);
            return ResultGenerator.genSuccessResult(process);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }







}
