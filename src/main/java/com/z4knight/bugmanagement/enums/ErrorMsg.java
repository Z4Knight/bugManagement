package com.z4knight.bugmanagement.enums;

/**
 * @Author Z4knight
 * @Date 2018/1/9 16:57
 *
 * 提示信息枚举类
 */
public enum ErrorMsg {
    DATA_OVERFLOW("数据量过大，请分页!"),
    DATA_NOT_EXIST("请求数据不存在!"),
    GROUP_NAME_EXIST("小组名称已存在!"),
    GROUP_CODE_REQUIRED("小组编码必填!"),
    GROUP_NAME_REQUIRED("小组名称必填!"),
    REGISTER_REQUIRED("登记人必填!"),
    MODIFIER_REQUIRED("修改人必填!"),

    SYSTEM_NAME_EXIST("系统名称已存在"),
    SYSTEM_CODE_REQUIRED("系统编码必填"),
    SYSTEM_NAME_REQUIRED("系统名称必填"),

    ;

    private final String msg;

    ErrorMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
