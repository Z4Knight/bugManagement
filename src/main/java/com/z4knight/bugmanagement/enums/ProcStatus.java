package com.z4knight.bugmanagement.enums;

/**
 * @Author Z4knight
 * @Date 2018/1/18 16:55
 *
 * 流程状态-枚举类
 */
public enum ProcStatus {
    UNTREATED("未处理"),
    BEING_PROCESSED("处理中"),
    HAS_PROCESSED("已处理"),
    HAS_FINISHED("已完结"),
    ;

    private final String msg;

    ProcStatus(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
