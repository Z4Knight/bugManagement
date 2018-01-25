package com.z4knight.bugmanagement.controller;

import com.z4knight.bugmanagement.dataobject.ProjectGroup;
import com.z4knight.bugmanagement.enums.ErrorMsg;
import com.z4knight.bugmanagement.enums.ReqType;
import com.z4knight.bugmanagement.form.ProjectGroupForm;
import com.z4knight.bugmanagement.param.ProjectGroupFilter;
import com.z4knight.bugmanagement.resultVO.Result;
import com.z4knight.bugmanagement.resultVO.ResultGenerator;
import com.z4knight.bugmanagement.service.ProjectGroupService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.rmi.ServerException;
import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/8 14:22
 *
 * 小组管理-控制类实现
 */

@RestController
@RequestMapping("/groupManagement")
public class ProjectGroupController {

    @Autowired
    private ProjectGroupService service;

    @PostMapping("/list")
    public Result list(@RequestParam(value = "page", defaultValue = "0") Integer page,
                       @RequestParam(value = "size", defaultValue = "30") Integer size) {
        try {
            // 请求成功，则按接口定义，返回成功信息以及数据
            List<ProjectGroup> groupList = service.selectAll(page, size);
            return ResultGenerator.genSuccessResult(groupList);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PostMapping("/add")
    public Result add(@RequestBody ProjectGroupForm projectGroupForm) {
        try {
            // 对输入数据进行校验
            ProjectGroupFilter.valid(projectGroupForm, ReqType.ADD);
            // 请求成功，则按接口定义，返回成功信息以及数据
            ProjectGroup projectGroup = service.save(projectGroupForm);
            return ResultGenerator.genSuccessResult(projectGroup);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PostMapping("/selectByGroupId")
    public Result selectByGroupId(@RequestParam(value = "groupId") String groupId) {
        try {
            // 请求成功，则按接口定义，返回成功信息以及数据
            ProjectGroup projectGroup = service.selectByGroupId(groupId);
            return ResultGenerator.genSuccessResult(projectGroup);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PostMapping("/updateByGroupId")
    public Result updateByGroupId(@RequestBody ProjectGroupForm projectGroupForm) {
        try {
            // 对输入数据进行校验
            ProjectGroupFilter.valid(projectGroupForm, ReqType.UPDATE);
            // 请求成功，则按接口定义，返回成功信息以及数据
            ProjectGroup projectGroup = service.update(projectGroupForm);
            return ResultGenerator.genSuccessResult(projectGroup);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @DeleteMapping("/deleteByGroupId")
    public Result deleteByGroupId(@RequestBody List<String> groupIds) {
        try {
            // 请求成功，则按接口定义，返回成功信息以及数据
            int result = service.delete(groupIds);
            return ResultGenerator.genSuccessResult(result);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

}
