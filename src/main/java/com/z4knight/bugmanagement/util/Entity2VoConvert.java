package com.z4knight.bugmanagement.util;

import com.z4knight.bugmanagement.dataobject.HistoricProcess;
import com.z4knight.bugmanagement.dataobject.ProjectGroup;
import com.z4knight.bugmanagement.dataobject.TeamUser;
import com.z4knight.bugmanagement.dataobject.TestSystem;
import com.z4knight.bugmanagement.enums.OpenCode;
import com.z4knight.bugmanagement.vo.HistoricProcessVO;
import com.z4knight.bugmanagement.vo.ProjectGroupVO;
import com.z4knight.bugmanagement.vo.TeamUserVO;
import com.z4knight.bugmanagement.vo.TestSystemVO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @Author Z4knight
 * @Date 2018/1/30 10:11
 *
 * 实体类转换前端展示工具类
 */
public class Entity2VoConvert {

    // 小组管理
    public static List<ProjectGroupVO> convertGroup(List<ProjectGroup> projectGroupList) {
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

    // 被测系统
    public static List<TestSystemVO> convertSystem(List<TestSystem> testSystemList) {
        List<TestSystemVO> testSystemVOList = new ArrayList<>();
        TestSystemVO testSystemVO;
        for (TestSystem testSystem : testSystemList) {
            testSystemVO = new TestSystemVO();
            testSystemVO.setCreateTime(testSystem.getCreateTime());
            testSystemVO.setRegister(testSystem.getRegister());
            testSystemVO.setNote(testSystem.getNote());
            testSystemVO.setModifier(testSystem.getModifier());
            testSystemVO.setEditTime(testSystem.getEditTime());
            testSystemVO.setVersionNumber(testSystem.getVersionNumber());
            testSystemVO.setTestDirector(testSystem.getTestDirector());
            testSystemVO.setSystemName(testSystem.getSystemName());
            testSystemVO.setSystemId(testSystem.getSystemId());
            testSystemVO.setDevDirector(testSystem.getDevDirector());
            testSystemVO.setDescription(testSystem.getDescription());
            // 转换 open
            if (testSystem.getOpen().equals(OpenCode.OPEN.code())) {
                testSystemVO.setOpen(true);
            } else {
                testSystemVO.setOpen(false);
            }
            testSystemVOList.add(testSystemVO);
        }
        return testSystemVOList;
    }

    // 小组用户
    public static List<TeamUserVO> convertUser(List<TeamUser> userList) {
        List<TeamUserVO> userVOList = new ArrayList<>();
        TeamUserVO userVO;
        for (TeamUser  user : userList) {
            userVO = new TeamUserVO();
            BeanUtils.copyProperties(user, userVO);
            userVOList.add(userVO);
        }
        return userVOList;
    }

    // 流转记录
    public static List<HistoricProcessVO> convertProcessRecord(List<HistoricProcess> processList) {
        List<HistoricProcessVO> voList = new ArrayList<>();
        HistoricProcessVO processVO;
        for (HistoricProcess process : processList) {
            processVO = new HistoricProcessVO();
            BeanUtils.copyProperties(process, processVO);
            voList.add(processVO);
        }
        // 根据处理时间排序
        List<HistoricProcessVO> processVOS = voList.stream().sorted(Comparator.comparing(HistoricProcessVO::getProcTime))
                .collect(toList());
        return processVOS;
    }
}
