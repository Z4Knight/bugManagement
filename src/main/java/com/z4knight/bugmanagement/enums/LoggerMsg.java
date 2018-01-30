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

    // 工单管理
    ORDER_MANAGER_QUERY_LIST("【工单管理】-查询列表"),
    ORDER_MANAGER_ADD("【工单管理】-增加工单"),
    ORDER_MANAGER_DELETE("【工单管理】-删除工单"),
    ORDER_MANAGER_QUERY_POINT("【工单管理】-查询指定工单"),
    ORDER_MANAGER_UPDATE("【工单管理】-修改工单"),


    // 流转管理-信息
    PROCESS_MANAGER_MSG_ADD("【流转管理】-保存流转信息"),
    PROCESS_MANAGER_MSG_QUERY_LIST("【流转管理】-查询流转信息列表"),
    PROCESS_MANAGER_MSG_QUERY_POINT("【流转管理】-查询单个流转信息"),
    PROCESS_MANAGER_MSG_DELETE("【流转管理】-删除流转信息"),
    PROCESS_MANAGER_MSG_UPDATE("【流转管理】-更新流转信息"),


    // 流转管理-记录
    PROCESS_MANAGER_RECORD_ADD("【流转管理】-保存流转记录"),
    PROCESS_MANAGER_RECORD_QUERY_LIST("【流转管理】-查询流转记录列表"),
    PROCESS_MANAGER_RECORD_QUERY_POINT("【流转管理】-查询单个流转记录"),
    PROCESS_MANAGER_RECORD_DELETE("【流转管理】-删除流转记录"),
    PROCESS_MANAGER_RECORD_UPDATE("【流转管理】-更新流转记录"),


    // 用户认证管理
    USER_MANAGER_VERIFY_AUTH_HEADERS("【用户认证管理】-验证请求头信息"),
    USER_MANAGER_AUTH_TOKEN("【用户认证管理】-TOKEN 信息管理"),

    // 用户管理
    USER_MANAGER_QUERY_LIST("【用户管理】-查询列表"),
    USER_MANAGER_ADD("【用户管理】-增加用户"),
    USER_MANAGER_DELETE("【用户管理】-删除用户"),
    USER_MANAGER_QUERY_POINT("【用户管理】-查询指定用户"),
    USER_MANAGER_UPDATE("【用户管理】-修改用户"),
    USER_MANAGER_LOGIN("【用户管理】-用户登录")

    ;

    private final String msg;

    LoggerMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
