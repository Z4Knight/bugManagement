package com.z4knight.bugmanagement.enums;

/**
 * @Author Z4knight
 * @Date 2018/1/24 15:10
 *
 * 日志打印消息枚举类
 */
public enum LoggerMsg {

    // 小组管理
    GROUP_MANAGER_QUERY_LIST("【小组管理】-查询列表"),
    GROUP_MANAGER_ADD("【小组管理】-增加小组"),
    GROUP_MANAGER_DELETE("【小组管理】-删除小组"),
    GROUP_MANAGER_QUERY_POINT("【小组管理】-查询指定小组"),
    GROUP_MANAGER_UPDATE("【小组管理】-修改小组"),

    // 被测系统管理
    SYSTEM_MANAGER_QUERY_LIST("【被测系统管理】-查询列表"),
    SYSTEM_MANAGER_ADD("【被测系统管理】-增加系统"),
    SYSTEM_MANAGER_DELETE("【被测系统管理】-删除系统"),
    SYSTEM_MANAGER_QUERY_POINT("【被测系统管理】-查询指定系统"),
    SYSTEM_MANAGER_UPDATE("【被测系统管理】-修改系统"),

    ;

    private final String msg;

    LoggerMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
