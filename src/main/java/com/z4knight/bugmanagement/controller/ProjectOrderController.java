package com.z4knight.bugmanagement.controller;

import com.z4knight.bugmanagement.dataobject.ProjectOrder;
import com.z4knight.bugmanagement.enums.ReqType;
import com.z4knight.bugmanagement.form.ProjectOrderForm;
import com.z4knight.bugmanagement.param.ProjectOrderFilter;
import com.z4knight.bugmanagement.resultVO.Result;
import com.z4knight.bugmanagement.resultVO.ResultGenerator;
import com.z4knight.bugmanagement.service.ProjectOrderService;
import com.z4knight.bugmanagement.vo.ProjectOrderDetailVO;
import com.z4knight.bugmanagement.vo.ProjectOrderPaneVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/12 14:54
 *
 * 工单管理面板-控制类
 */

@RestController
@RequestMapping("/orderManagement")
public class ProjectOrderController {

    @Autowired
    private ProjectOrderService service;

    @PostMapping("/list")
    public Result list(@RequestParam(value = "page", defaultValue = "0") Integer page,
                       @RequestParam(value = "size", defaultValue = "30") Integer size) {
        try {
            // 请求成功，则按接口定义，返回成功信息以及数据
            List<ProjectOrderPaneVO> orderList = service.selectAll(page, size);
            return ResultGenerator.genSuccessResult(orderList);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PostMapping("/add")
    public Result add(@RequestBody ProjectOrderForm projectOrderForm) {
        try {
            // 对输入数据进行校验
            ProjectOrderFilter.valid(projectOrderForm, ReqType.ADD);
            // 请求成功，则按接口定义，返回成功信息以及数据
            ProjectOrder projectOrder = service.save(projectOrderForm);
            return ResultGenerator.genSuccessResult(projectOrder);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PostMapping("/selectByOrderId")
    public Result selectByOrderId(@RequestParam(value = "orderId") String orderId) {
        try {
            // 请求成功，则按接口定义，返回成功信息以及数据
            ProjectOrderDetailVO projectOrder = service.selectByOrderIdToDetail(orderId);
            return ResultGenerator.genSuccessResult(projectOrder);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PostMapping("/updateByOrderId")
    public Result updateByOrderId(@RequestBody ProjectOrderForm projectOrderForm) {
        try {
            // 对输入数据进行校验
            ProjectOrderFilter.valid(projectOrderForm, ReqType.UPDATE);
            // 请求成功，则按接口定义，返回成功信息以及数据
            ProjectOrderPaneVO projectOrder = service.updateToPane(projectOrderForm);
            return ResultGenerator.genSuccessResult(projectOrder);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @DeleteMapping("/deleteByOrderId")
    public Result deleteByOrderId(@RequestBody List<String> orderIds) {
        try {
            // 请求成功，则按接口定义，返回成功信息以及数据
            service.delete(orderIds);
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

}
