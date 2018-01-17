package com.z4knight.bugmanagement.controller;

import com.z4knight.bugmanagement.dataobject.ProjectTask;
import com.z4knight.bugmanagement.enums.ReqType;
import com.z4knight.bugmanagement.form.ProjectTaskForm;
import com.z4knight.bugmanagement.param.ProjectTaskFilter;
import com.z4knight.bugmanagement.resultVO.Result;
import com.z4knight.bugmanagement.resultVO.ResultGenerator;
import com.z4knight.bugmanagement.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/17 16:37
 *
 * 任务-控制类
 */
@RestController
@RequestMapping("/taskManagement")
public class ProjectTaskController {
    @Autowired
    private ProjectTaskService service;

    @PostMapping("/list")
    public Result list(@RequestParam(value = "page", defaultValue = "0") Integer page,
                       @RequestParam(value = "size", defaultValue = "10") Integer size) {
        try {
            // 请求成功，则按接口定义，返回成功信息以及数据
            List<ProjectTask> taskList = service.selectAll(page, size);
            return ResultGenerator.genSuccessResult(taskList);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PostMapping("/add")
    public Result add(@RequestBody ProjectTaskForm projectTaskForm) {
        try {
            // 对输入数据进行校验
            ProjectTaskFilter.valid(projectTaskForm, ReqType.ADD);
            // 请求成功，则按接口定义，返回成功信息以及数据
            ProjectTask projectTask = service.save(projectTaskForm);
            return ResultGenerator.genSuccessResult(projectTask);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PostMapping("/selectByTaskId")
    public Result selectByTaskId(@RequestParam(value = "taskId") String taskId) {
        try {
            // 请求成功，则按接口定义，返回成功信息以及数据
            ProjectTask projectTask = service.selectByTaskId(taskId);
            return ResultGenerator.genSuccessResult(projectTask);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PostMapping("/updateByTaskId")
    public Result updateByTaskId(@RequestBody ProjectTaskForm projectTaskForm) {
        try {
            // 对输入数据进行校验
            ProjectTaskFilter.valid(projectTaskForm, ReqType.UPDATE);
            // 请求成功，则按接口定义，返回成功信息以及数据
            ProjectTask projectTask = service.update(projectTaskForm);
            return ResultGenerator.genSuccessResult(projectTask);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @DeleteMapping("/deleteByTaskId")
    public Result deleteByTaskId(@RequestParam(value = "taskId") String taskId) {
        try {
            // 请求成功，则按接口定义，返回成功信息以及数据
            service.delete(taskId);
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }


}
