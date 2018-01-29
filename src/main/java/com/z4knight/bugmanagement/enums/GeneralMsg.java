package com.z4knight.bugmanagement.enums;

/**
 * @Author Z4knight
 * @Date 2018/1/25 10:31
 */
public enum GeneralMsg {


    YES("是"),
    NO("否"),

    OPEN_SUCCESS("开启成功"),
    CLOSE_SUCCESS("关闭成功"),

    ;

    private final String msg;

    GeneralMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
