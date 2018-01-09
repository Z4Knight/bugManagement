package com.z4knight.bugmanagement.enums;

/**
 * @Author Z4knight
 * @Date 2018/1/9 14:12
 */
public enum ReqType {

    ADD("add"),
    UPDATE("update");

    private final String type;

    ReqType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
