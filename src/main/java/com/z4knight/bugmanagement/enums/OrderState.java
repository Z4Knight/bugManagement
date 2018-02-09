package com.z4knight.bugmanagement.enums;

/**
 * @Author Z4knight
 * @Date 2018/1/12 14:04
 *
 * 工单状态，类型枚举类
 */
public enum OrderState {

    // 状态
    NEW_ORDER("新建"),
    PASS_SCHEDULE_APPROVAL("排期审批通过"),
    WORK_LOAD_HAS_ASSESS("工作量已评估"),
    TEST_PREPARE("测试准备"),
    PERMIT_TEST_RUNNING("准入测试中"),
    UAT_TEST_RUNNING("UAT测试中"),
    UAT_TEST_RESULT_CONFIRM("UAT测试结果确认"),

    // 关闭类型
    NOT_CLOSED("未关闭"),
    NORMAL_CLOSED("正常关闭"),

    // 修改来源-管理界面 0、流转界面 1
    FROM_MANAGER("管理"),
    FROM_PROCESS("流转"),

    // 流程节点名称
    PROC_WORK_LOAD_ASSESS("工作量评估"),
    PROC_TEST_PREPARE("测试准备"),
    PROC_SMOKE_TEST("冒烟测试"),
    PROC_TEST_EXECUTE("测试执行"),
    PROC_SUBMIT_UAT_TEST("提交UAT测试"),

    ;

    private final String msg;

    OrderState(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

}
