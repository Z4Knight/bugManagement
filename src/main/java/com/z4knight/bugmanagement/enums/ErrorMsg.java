package com.z4knight.bugmanagement.enums;

/**
 * @Author Z4knight
 * @Date 2018/1/9 16:57
 *
 * 提示信息枚举类
 */
public enum ErrorMsg {
    // 公共
    DATA_OVERFLOW("数据量过大，请分页!"),
    DATA_NOT_EXIST("请求数据不存在!"),
    REGISTER_REQUIRED("登记人必填!"),
    MODIFIER_REQUIRED("修改人必填!"),
    NO_MESSAGE_DELETED("删除信息为空，请选择删除信息"),

    // 小组管理
    GROUP_NAME_EXIST("小组名称已存在!"),
    GROUP_CODE_REQUIRED("小组编码必填!"),
    GROUP_NAME_REQUIRED("小组名称必填!"),
    GROUP_OPEN_REQUIRED("小组开启关闭状态必填！"),


    // 被测系统
    SYSTEM_NAME_EXIST("系统名称已存在"),
    SYSTEM_CODE_REQUIRED("系统编码必填"),
    SYSTEM_NAME_REQUIRED("系统名称必填"),
    SYSTEM_OPEN_REQUIRED("系统开启关闭状态必填！"),

    // 工单管理
    ORDER_NAME_EXIST("工单名称已存在"),
    ORDER_CODE_REQUIRED("工单编码必填"),
    ORDER_NAME_REQUIRED("工单名称必填"),
    ORDER_HAS_FLOW_NOT_MODIFIY("工单已流转, 不能修改！"),
    ORDER_HAS_FLOW_NOT_DELETE("工单已流转, 不能删除"),


    // 任务管理
    TASK_NAME_EXIST("任务名称已存在"),
    TASK_CODE_REQUIRED("任务编码必填"),
    TASK_NAME_REQUIRED("任务名称必填"),
    OWN_ORDER_NOT_EXIST("所属工单不存在，请重新选择！"),


    // 流程管理
    PRO_DEF_KEY_NOT_EXIST("流程定义key不存在"),
    ASSIGNER_NOT_EXIST("受让人不存在!"),
    CUR_ASSIGNER_HAS_NOT_FLOW_DATA("当前受让人无流转数据!"),
    BUSINESS_CODE_NOT_EXIST("业务编码不存在！"),
    BUSINESS_CODE_REQUIRED("业务编码必填！"),
    BUSINESS_TYPE_REQUIRED("业务类型必填！"),


    // 用户认证管理
    INVALID_AUTHORIZATION_HEADER("不合法的授权头信息！"),
    TOKEN_EXPIRED("授权 Token 已过期，请重新登录！"),
    OTHER_TOKEN_EXCEPTION("授权 Token 异常，请重新登录！"),

    // 小组用户管理
    GROUP_NOT_EXIST_USERS("此小组信息不存在用户！"),
    USER_NAME_REQUIRED("用户名必填！"),
    USER_NAME_OR_PSWD_ERROR("用户名或密码错误！"),
    USER_PSWD_REQUIRED("密码必填！"),
    CUR_USER_NAME_NOT_EXIST("登录已过期，请重新登录！"),

    ;

    private final String msg;

    ErrorMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
