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
    BUSINESS_CODE_NOT_EXIST("业务编码不存在"),
    ;

    private final String msg;

    ErrorMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
