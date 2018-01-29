package com.z4knight.bugmanagement.service;

import com.z4knight.bugmanagement.dataobject.ProjectGroup;
import com.z4knight.bugmanagement.form.OpenClose;
import com.z4knight.bugmanagement.form.ProjectGroupForm;
import com.z4knight.bugmanagement.vo.ProjectGroupVO;

import java.util.List;


/**
 * @Author Z4knight
 * @Date 2018/1/8 13:43
 *
 * 项目组-服务的接口
 */


public interface ProjectGroupService {

    List<ProjectGroupVO> selectAll(Integer page, Integer size);

    ProjectGroup save(ProjectGroupForm projectGroupForm);

    ProjectGroup update(ProjectGroupForm projectGroupForm);

    ProjectGroup selectByGroupId(String groupId);

    ProjectGroup selectByGroupName(String groupName);

    int delete(List<String> groupIds);

    String update(OpenClose openClose);

}
