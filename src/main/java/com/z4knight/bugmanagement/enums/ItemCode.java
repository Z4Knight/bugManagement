package com.z4knight.bugmanagement.enums;

/**
 * @Author Z4knight
 * @Date 2018/1/8 15:35
 *
 * 生成编码所需分类枚举代码类
 */
public enum ItemCode {

    // 小组
    GROUP("G"),
    // 系统
    SYSTERM("S"),
    // 工单
    PROJECT("P"),
    // 任务
    TASK("T");

    private final String code;

    ItemCode(String code) {
        this.code = code;
    }


    public String code() {
        return code;
    }
}
