package com.z4knight.bugmanagement.util;

import com.z4knight.bugmanagement.dataobject.ProjectGroup;
import com.z4knight.bugmanagement.enums.OpenCode;
import com.z4knight.bugmanagement.vo.ProjectGroupVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/29 17:33
 */
public class Group2GroupVoConverter {

    public static List<ProjectGroupVO> convert(List<ProjectGroup> projectGroupList) {
        List<ProjectGroupVO> projectGroupVOList = new ArrayList<>();
        ProjectGroupVO projectGroupVO;
        for (ProjectGroup projectGroup : projectGroupList) {
            projectGroupVO = new ProjectGroupVO();
            projectGroupVO.setCreateTime(projectGroup.getCreateTime());
            projectGroupVO.setRegister(projectGroup.getRegister());
            projectGroupVO.setNote(projectGroup.getNote());
            projectGroupVO.setModifier(projectGroup.getModifier());
            projectGroupVO.setGroupName(projectGroup.getGroupName());
            projectGroupVO.setGroupManager(projectGroup.getGroupManager());
            projectGroupVO.setGroupId(projectGroup.getGroupId());
            projectGroupVO.setEditTime(projectGroup.getEditTime());
            // 转换 open
            if (projectGroup.getOpen().equals(OpenCode.OPEN.code())) {
                projectGroupVO.setOpen(true);
            } else {
                projectGroupVO.setOpen(false);
            }
            projectGroupVOList.add(projectGroupVO);
        }
        return projectGroupVOList;
    }
}
