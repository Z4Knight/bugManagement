package com.z4knight.bugmanagement.repository;

import com.z4knight.bugmanagement.dataobject.ProjectGroup;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/5 16:53
 *
 * 小组管理-mapper接口
 */
public interface ProjectGroupMapper {

    List<ProjectGroup> selectAll();

    void update(ProjectGroup group);

    ProjectGroup selectByGroupId(String groupId);

    void save(ProjectGroup group);

    int delete(List<String> groupIds);

    ProjectGroup selectByGroupName(String groupName);
}
