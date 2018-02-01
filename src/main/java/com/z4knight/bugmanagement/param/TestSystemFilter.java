package com.z4knight.bugmanagement.param;

import com.z4knight.bugmanagement.enums.ErrorMsg;
import com.z4knight.bugmanagement.enums.ReqType;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.form.TestSystemForm;
import org.springframework.util.StringUtils;

/**
 * @Author Z4knight
 * @Date 2018/1/10 16:31
 *
 * 被测系统输入参数筛选工具类
 */
public class TestSystemFilter {

    public static void valid(TestSystemForm testSystemForm, ReqType type) {
        if (StringUtils.isEmpty(testSystemForm.getSystemName())) {
            throw new ServiceException(ErrorMsg.SYSTEM_NAME_REQUIRED.getMsg());
        } else if (ReqType.UPDATE.equals(type) && StringUtils.isEmpty(testSystemForm.getSystemId())) {
            throw new ServiceException(ErrorMsg.SYSTEM_CODE_REQUIRED.getMsg());
        }
    }
}
