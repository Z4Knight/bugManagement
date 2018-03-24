package com.z4knight.bugmanagement.enums;

/**
 * @Author Z4knight
 * @Date 2018/1/25 10:31
 *
 * 通用提示信息枚举类
 */
public enum GeneralMsg {

    // 是否状态提示语
    YES("是"),
    NO("否"),

    // 开启关闭状态提示语
    OPEN_SUCCESS("开启成功"),
    CLOSE_SUCCESS("关闭成功"),

    // JWT 相关
    AUTH_HEADERS("Authorization"),
    AUTH_SEGMENT("Bearer "),
    AUTH_USER_NAME("userName"),
    AUTH_ROLE("role"),
    SECRET_KEY("base64EncodedSecretKey"),

    ;

    private final String msg;

    GeneralMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
