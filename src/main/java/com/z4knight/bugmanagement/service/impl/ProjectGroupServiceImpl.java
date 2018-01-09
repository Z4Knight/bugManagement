package com.z4knight.bugmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.z4knight.bugmanagement.enums.ErrorMsg;
import com.z4knight.bugmanagement.enums.ItemCode;
import com.z4knight.bugmanagement.dataobject.ProjectGroup;
import com.z4knight.bugmanagement.enums.OpenCode;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.form.ProjectGroupForm;
import com.z4knight.bugmanagement.repository.ProjectGroupMapper;
import com.z4knight.bugmanagement.service.ProjectGroupService;
import com.z4knight.bugmanagement.util.CodeGeneratorUtil;
import com.z4knight.bugmanagement.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.List;


/**
 * @Author Z4knight
 * @Date 2018/1/8 13:44
 *
 * 项目组-服务的实现类
 */

@Service
public class ProjectGroupServiceImpl implements ProjectGroupService{

    @Autowired
    private ProjectGroupMapper mapper;

    @Override
    public List<ProjectGroup> selectAll(Integer page, Integer size) {
        // 起始页
        int startPage = page.intValue();
        // 每页显示多少条
        int pageRow = size.intValue();
        if (startPage == 0 && pageRow == 0) {
            List<ProjectGroup> groupList = mapper.selectAll();
            if (groupList != null && groupList.size() > 1000L) {
                throw new ServiceException(ErrorMsg.DATA_OVERFLOW.getMsg());
            }
        }
        PageHelper.startPage(startPage, pageRow);
        List<ProjectGroup> groupList = mapper.selectAll();
        PageInfo<ProjectGroup> groupPageInfo = new PageInfo<>(groupList);
        groupList = groupPageInfo.getList();
        if (null == groupList || groupList.size() == 0) {
            throw new ServiceException(ErrorMsg.NOT_EXIST.getMsg());
        }
        return groupList;
    }

    @Override
    public ProjectGroup save(ProjectGroupForm projectGroupForm) {
        ProjectGroup group = null;
        group = selectByGroupName(projectGroupForm.getGroupName());
        if (null != group) {
            throw new ServiceException(ErrorMsg.GROUP_NAME_EXIST.getMsg());
        }
        group = new ProjectGroup();
        // 设置来自于前端传送的接口信息
        BeanUtils.copyProperties(projectGroupForm, group);
        // 默认开启
        group.setOpen(OpenCode.OPEN.code());
        // 设置自动生成编码
        group.setGroupId(CodeGeneratorUtil.generateCode(ItemCode.GROUP));
        // 设置登录与修改日期为系统当前日期
        group.setCreateTime(DateUtil.getCurrentDate());
        group.setEditTime(DateUtil.getCurrentDate());
        mapper.save(group);
        return group;
    }

    @Override
    public ProjectGroup update(ProjectGroupForm projectGroupForm) {
        ProjectGroup result = new ProjectGroup();
        ProjectGroup group = selectByGroupId(projectGroupForm.getGroupId());
        // 设置来自于前端传送的接口信息
        BeanUtils.copyProperties(projectGroupForm, result);
        // 设置其他原本存于数据库中的数据
        result.setOpen(group.getOpen());
        result.setCreateTime(group.getCreateTime());
        result.setEditTime(DateUtil.getCurrentDate());
        result.setRegister(group.getRegister());
        mapper.update(result);
        return result;
    }

    @Override
    public ProjectGroup selectByGroupId(String groupId) {
        if (StringUtils.isEmpty(groupId)) {
            throw new ServiceException(ErrorMsg.GROUP_CODE_REQUIRED.getMsg());
        }
        ProjectGroup group = mapper.selectByGroupId(groupId);
        if (null == group) {
            throw new ServiceException(ErrorMsg.NOT_EXIST.getMsg());
        }
        return group;
    }

    @Override
    public void delete(String groupId) {
        if (StringUtils.isEmpty(groupId)) {
            throw new ServiceException(ErrorMsg.GROUP_CODE_REQUIRED.getMsg());
        }
        ProjectGroup group = selectByGroupId(groupId);
        if (null == group) {
            throw new ServiceException(ErrorMsg.NOT_EXIST.getMsg());
        }
        mapper.delete(groupId);
    }

    @Override
    public ProjectGroup selectByGroupName(String groupName) {
        if (StringUtils.isEmpty(groupName)) {
            throw new ServiceException(ErrorMsg.GROUP_NAME_REQUIRED.getMsg());
        }
        ProjectGroup group = mapper.selectByGroupName(groupName);
        return group;
    }
}
