package com.z4knight.bugmanagement.param;

import com.z4knight.bugmanagement.enums.ErrorMsg;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.form.ProcessForm;
import org.springframework.util.StringUtils;

/**
 * @Author Z4knight
 * @Date 2018/2/1 13:12
 *
 * 通用流转信息输入参数筛选工具类
 */
public class GeneralProcessFilter {

    public static void valid(ProcessForm processForm) {
        if (StringUtils.isEmpty(processForm.getObjectId())) {
            throw new ServiceException(ErrorMsg.BUSINESS_CODE_REQUIRED.getMsg());
        } else if (StringUtils.isEmpty(processForm.getObjectType())) {
            throw new ServiceException(ErrorMsg.BUSINESS_TYPE_REQUIRED.getMsg());
        }
    }

}
