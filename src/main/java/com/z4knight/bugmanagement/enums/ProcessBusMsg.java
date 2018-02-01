package com.z4knight.bugmanagement.enums;

/**
 * @Author Z4knight
 * @Date 2018/1/18 16:40
 *
 * 通用流程业务名称-枚举类
 */
public enum ProcessBusMsg {


    ORDER("工单"),

    TASK("任务"),

    BUG("缺陷")

    ;

    private final String msg;

    ProcessBusMsg(String msg) {
        this.msg = msg;
    }


    public String getMsg() {
        return msg;
    }
}
