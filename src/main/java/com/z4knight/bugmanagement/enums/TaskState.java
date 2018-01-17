package com.z4knight.bugmanagement.enums;

/**
 * @Author Z4knight
 * @Date 2018/1/16 17:01
 *
 * 任务状态码
 */
public enum  TaskState {

    NEW_TASK("新建"),
    UNDER_REVIEW("审核中"),
    ;

    private final String msg;

    TaskState(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
