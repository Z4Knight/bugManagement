package com.z4knight.bugmanagement.enums;

/**
 * @Author Z4knight
 * @Date 2018/1/22 14:54
 *
 * 流转变量-枚举类
 */
public enum ProcVal {

    ASSIGNER("procAssigner"),

    RESULT("procResult"),
    ;


    private final String val;

    ProcVal(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
