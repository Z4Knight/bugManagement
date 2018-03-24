package com.z4knight.bugmanagement.param;

import com.z4knight.bugmanagement.enums.ErrorMsg;
import com.z4knight.bugmanagement.enums.ReqType;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.form.ProjectTaskForm;
import org.springframework.util.StringUtils;

/**
 * @Author Z4knight
 * @Date 2018/1/16 17:21
 *
 *
 * 任务输入参数筛选工具类
 */
public class ProjectTaskFilter {

    public static void valid(ProjectTaskForm projectTaskForm, ReqType type) {
        if (StringUtils.isEmpty(projectTaskForm.getTaskName())) {
            throw new ServiceException(ErrorMsg.TASK_NAME_REQUIRED.getMsg());
        } else if (ReqType.UPDATE.equals(type) && StringUtils.isEmpty(projectTaskForm.getTaskId())) {
            throw new ServiceException(ErrorMsg.TASK_CODE_REQUIRED.getMsg());
        }
    }
}
