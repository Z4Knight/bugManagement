package com.z4knight.bugmanagement.controller;

import com.z4knight.bugmanagement.dataobject.TeamUser;
import com.z4knight.bugmanagement.form.ProjectGroupForm;
import com.z4knight.bugmanagement.form.TeamUserForm;
import com.z4knight.bugmanagement.form.UserLoginForm;
import com.z4knight.bugmanagement.param.UserFilter;
import com.z4knight.bugmanagement.resultVO.Result;
import com.z4knight.bugmanagement.resultVO.ResultGenerator;
import com.z4knight.bugmanagement.security.JwtUtil;
import com.z4knight.bugmanagement.service.TeamUserService;
import com.z4knight.bugmanagement.vo.TeamUserVO;
import com.z4knight.bugmanagement.vo.TestSystemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author Z4knight
 * @Date 2018/1/29 13:40
 *
 * 用户管理-控制类
 */

@RestController
@RequestMapping("/userManagement")
public class UserManageController {

    @Autowired
    private TeamUserService teamUserService;

    @PostMapping("/login")
    public Result login(@RequestBody UserLoginForm userLoginForm) {
        try {
            // 请求成功，则按接口定义，返回成功信息以及数据
            TeamUserVO result = teamUserService.checkUserInfo(userLoginForm);
            return ResultGenerator.genSuccessResult(JwtUtil.getToken(result.getUserName(), result.getRole()));
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @GetMapping("/list")
    public Result list() {
        try {
            // 请求成功，则按接口定义，返回成功信息以及数据
            List<TeamUser> userList = teamUserService.selectAll();
            return ResultGenerator.genSuccessResult(userList);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @GetMapping("/success")
    public Result success() {
        try {
            String currentUserName = JwtUtil.getCurrentUserName();
            String currentUserRole = JwtUtil.getCurUserRole();
            return ResultGenerator.genSuccessResult("login success! welcome " + currentUserName
            + " role is " + currentUserRole);
        } catch (Exception e) {
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PostMapping("/selectByOwnGroup")
    public Result selectByOwnGroup(@RequestBody ProjectGroupForm groupForm) {
        try {
            String ownGroup = groupForm.getGroupName();
            List<TeamUserVO> userVOList = teamUserService.selectByOwnGroup(ownGroup);
            return ResultGenerator.genSuccessResult(userVOList);
        } catch (Exception e) {
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @PostMapping("/add")
    public Result add(@RequestBody TeamUserForm teamUserForm) {
        try {
            // 对输入数据进行校验
            UserFilter.valid(teamUserForm);
            // 请求成功，则按接口定义，返回成功信息以及数据
            TeamUser user = teamUserService.save(teamUserForm);
            return ResultGenerator.genSuccessResult(user);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }


}
