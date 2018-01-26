package com.z4knight.bugmanagement.enums;

/**
 * @Author Z4knight
 * @Date 2018/1/25 10:31
 */
public enum GeneralMsg {

    YES("是"),
    NO("否"),

    ;

    private final String msg;

    GeneralMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
