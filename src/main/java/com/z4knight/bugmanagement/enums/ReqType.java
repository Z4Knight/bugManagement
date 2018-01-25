package com.z4knight.bugmanagement.enums;

/**
 * @Author Z4knight
 * @Date 2018/1/9 14:12
 *
 * 请求参数校验区分枚举类
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
