package com.z4knight.bugmanagement.param;

import com.z4knight.bugmanagement.enums.ErrorMsg;
import com.z4knight.bugmanagement.enums.ReqType;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.form.TeamUserForm;
import org.springframework.util.StringUtils;

/**
 * @Author Z4knight
 * @Date 2018/3/24 9:41
 * 
 * 用户输入参数筛选工具类
 */
public class UserFilter {

    public static void valid(TeamUserForm teamUserForm) {
        if (StringUtils.isEmpty(teamUserForm.getUserName())) {
            throw new ServiceException(ErrorMsg.USER_NAME_REQUIRED.getMsg());
        }
    }
}
