package com.z4knight.bugmanagement.enums;

/**
 * @Author Z4knight
 * @Date 2018/1/12 14:04
 *
 * 工单状态码
 */
public enum OrderState {

    PASS_SCHEDULE_APPROVAL("排期审批通过"),
    DO_NOT_TEST("不需测试"),
    ;

    private final String msg;

    OrderState(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
