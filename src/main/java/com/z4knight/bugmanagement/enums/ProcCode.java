package com.z4knight.bugmanagement.enums;

/**
 * @Author Z4knight
 * @Date 2018/1/18 16:45
 *
 *
 * 流程变量枚举类
 */
public enum ProcCode {
    // 通过
    PASS("通过"),
    // 不通过
    NO_PASS("不通过"),
    // 无
    NOTHING("无"),


    ;


    private final String msg;

    ProcCode(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
