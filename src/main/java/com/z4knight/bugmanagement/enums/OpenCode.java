package com.z4knight.bugmanagement.enums;

/**
 * @Author Z4knight
 * @Date 2018/1/8 15:51
 *
 * 开启代码枚举类
 */
public enum OpenCode {
    // 开启
    OPEN(0),
    // 关闭
    CLOSE(1);

    private final int code;

    OpenCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
