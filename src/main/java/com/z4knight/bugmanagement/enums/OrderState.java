package com.z4knight.bugmanagement.enums;

/**
 * @Author Z4knight
 * @Date 2018/1/12 14:04
 *
 * 工单状态，类型枚举类
 */
public enum OrderState {

    // 状态
    PASS_SCHEDULE_APPROVAL("排期审批通过"),
    DO_NOT_TEST("不需测试"),

    // 关闭类型
    NOT_CLOSED("未关闭"),
    NORMAL_CLOSED("正常关闭"),
    FORCE_CLOSED("强制关闭"),

    // 修改来源-管理界面 0、流转界面 1
    FROM_MANAGER("管理"),
    FROM_PROCESS("流转"),

    ;

    private final String msg;

    OrderState(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
