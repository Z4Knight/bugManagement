package com.z4knight.bugmanagement.repository;

import com.z4knight.bugmanagement.dataobject.ProjectTask;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/16 17:28
 *
 * 任务-mapper接口
 */
public interface ProjectTaskMapper {

    List<ProjectTask> selectAll();

    void update(ProjectTask task);

    ProjectTask selectByTaskId(String taskId);

    void save(ProjectTask task);

    void delete(String taskId);

    ProjectTask selectByTaskName(String taskName);
}
