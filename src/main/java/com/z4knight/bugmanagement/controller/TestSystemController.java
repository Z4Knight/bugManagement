package com.z4knight.bugmanagement.controller;

import com.z4knight.bugmanagement.dataobject.TestSystem;
import com.z4knight.bugmanagement.enums.ReqType;
import com.z4knight.bugmanagement.form.TestSystemForm;
import com.z4knight.bugmanagement.param.TestSystemFilter;
import com.z4knight.bugmanagement.resultVO.Result;
import com.z4knight.bugmanagement.resultVO.ResultGenerator;
import com.z4knight.bugmanagement.service.TestSystemService;
import com.z4knight.bugmanagement.vo.TestSystemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/10 16:52
 *
 * 被测系统-控制类实现
 */

@RestController
@RequestMapping("/testSystemManagement")
public class TestSystemController {
    @Autowired
    private TestSystemService service;

    @PostMapping("/list")
    public Result list(@RequestParam(value = "page", defaultValue = "0") Integer page,
                       @RequestParam(value = "size", defaultValue = "30") Integer size) {
        try {
            // 请求成功，则按接口定义，返回成功信息以及数据
            List<TestSystemVO> systemList = service.selectAll(page, size);
            return ResultGenerator.genSuccessResult(systemList);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PostMapping("/add")
    public Result add(@RequestBody TestSystemForm testSystemForm) {
        try {
            // 对输入数据进行校验
            TestSystemFilter.valid(testSystemForm, ReqType.ADD);
            // 请求成功，则按接口定义，返回成功信息以及数据
            TestSystem testSystem = service.save(testSystemForm);
            return ResultGenerator.genSuccessResult(testSystem);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PostMapping("/selectBySystemId")
    public Result selectByGroupId(@RequestParam(value = "systemId") String systemId) {
        try {
            // 请求成功，则按接口定义，返回成功信息以及数据
            TestSystem testSystem = service.selectBySystemId(systemId);
            return ResultGenerator.genSuccessResult(testSystem);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PostMapping("/updateBySystemId")
    public Result updateByGroupId(@RequestBody TestSystemForm testSystemForm) {
        try {
            // 对输入数据进行校验
            TestSystemFilter.valid(testSystemForm, ReqType.UPDATE);
            // 请求成功，则按接口定义，返回成功信息以及数据
            TestSystem testSystem = service.update(testSystemForm);
            return ResultGenerator.genSuccessResult(testSystem);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @DeleteMapping("/deleteBySystemId")
    public Result deleteByGroupId(@RequestBody List<String> systemIds) {
        try {
            // 请求成功，则按接口定义，返回成功信息以及数据
            int result = service.delete(systemIds);
            return ResultGenerator.genSuccessResult(result);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }


}
