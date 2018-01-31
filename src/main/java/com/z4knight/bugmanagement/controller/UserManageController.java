package com.z4knight.bugmanagement.controller;

import com.z4knight.bugmanagement.form.ProjectGroupForm;
import com.z4knight.bugmanagement.form.TeamUserForm;
import com.z4knight.bugmanagement.form.UserLoginForm;
import com.z4knight.bugmanagement.resultVO.Result;
import com.z4knight.bugmanagement.resultVO.ResultGenerator;
import com.z4knight.bugmanagement.security.JwtUtil;
import com.z4knight.bugmanagement.service.TeamUserService;
import com.z4knight.bugmanagement.vo.TeamUserVO;
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
            UserLoginForm result = teamUserService.checkUserInfo(userLoginForm);
            return ResultGenerator.genSuccessResult(JwtUtil.getToken(result.getUserName()));
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @GetMapping("/success")
    public Result success() {
        try {
            String currentUserName = JwtUtil.getCurrentUserName();
            return ResultGenerator.genSuccessResult("login success! welcome " + currentUserName);
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

}
