package com.z4knight.bugmanagement.param;

import com.z4knight.bugmanagement.enums.ErrorMsg;
import com.z4knight.bugmanagement.enums.ReqType;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.form.ProjectOrderForm;
import org.springframework.util.StringUtils;

/**
 * @Author Z4knight
 * @Date 2018/1/12 14:59
 *
 * 工单输入参数筛选工具类
 */
public class ProjectOrderFilter {

    public static void valid(ProjectOrderForm projectOrderForm, ReqType type) {
        if (StringUtils.isEmpty(projectOrderForm.getOrderName())) {
            throw new ServiceException(ErrorMsg.ORDER_NAME_REQUIRED.getMsg());
        } else if (ReqType.ADD.equals(type) && StringUtils.isEmpty(projectOrderForm.getRegister())) {
            throw new ServiceException(ErrorMsg.REGISTER_REQUIRED.getMsg());
        } else if (StringUtils.isEmpty(projectOrderForm.getModifier())) {
            throw new ServiceException(ErrorMsg.MODIFIER_REQUIRED.getMsg());
        } else if (ReqType.UPDATE.equals(type) && StringUtils.isEmpty(projectOrderForm.getOrderId())) {
            throw new ServiceException(ErrorMsg.ORDER_CODE_REQUIRED.getMsg());
        }
    }
}
