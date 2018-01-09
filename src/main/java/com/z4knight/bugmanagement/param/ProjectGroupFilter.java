package com.z4knight.bugmanagement.param;


import com.z4knight.bugmanagement.enums.ErrorMsg;
import com.z4knight.bugmanagement.enums.ReqType;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.form.ProjectGroupForm;
import org.springframework.util.StringUtils;


/**
 * @Author Z4knight
 * @Date 2018/1/8 16:50
 *
 * 项目组输入参数筛选工具类
 */
public class ProjectGroupFilter {

    public static void valid(ProjectGroupForm projectGroupForm, ReqType type) {
        if (StringUtils.isEmpty(projectGroupForm.getGroupName())) {
            throw new ServiceException(ErrorMsg.GROUP_NAME_REQUIRED.getMsg());
        } else if (ReqType.ADD.equals(type) && StringUtils.isEmpty(projectGroupForm.getRegister())) {
            throw new ServiceException(ErrorMsg.REGISTER_REQUIRED.getMsg());
        } else if (StringUtils.isEmpty(projectGroupForm.getModifier())) {
            throw new ServiceException(ErrorMsg.MODIFIER_REQUIRED.getMsg());
        } else if (ReqType.UPDATE.equals(type) && StringUtils.isEmpty(projectGroupForm.getGroupId())) {
            throw new ServiceException(ErrorMsg.GROUP_CODE_REQUIRED.getMsg());
        }
    }
}
