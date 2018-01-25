package com.z4knight.bugmanagement.param;


import com.z4knight.bugmanagement.enums.ErrorMsg;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.form.ProcessOrderForm;
import org.springframework.util.StringUtils;

/**
 * @Author Z4knight
 * @Date 2018/1/12 14:59
 *
 * 流转工单输入参数筛选工具类
 */
public class ProcessOrderFilter {

    public static void valid(ProcessOrderForm form) {
       if (StringUtils.isEmpty(form.getOrderId())) {
           throw new ServiceException(ErrorMsg.ORDER_CODE_REQUIRED.getMsg());
       } else if (StringUtils.isEmpty(form.getProcAssigner())) {
           throw new ServiceException(ErrorMsg.ASSIGNER_NOT_EXIST.getMsg());
       }
    }
}
