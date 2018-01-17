package com.z4knight.bugmanagement.service;

import com.z4knight.bugmanagement.dataobject.ProjectTask;
import com.z4knight.bugmanagement.form.ProjectTaskForm;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/16 17:29
 *
 * 任务-服务类接口
 */
public interface ProjectTaskService {

    List<ProjectTask> selectAll(Integer page, Integer size);

    ProjectTask update(ProjectTaskForm projectTaskForm);

    ProjectTask selectByTaskId(String taskId);

    ProjectTask save(ProjectTaskForm projectTaskForm);

    void delete(String taskId);

    ProjectTask selectByTaskName(String taskName);

}
