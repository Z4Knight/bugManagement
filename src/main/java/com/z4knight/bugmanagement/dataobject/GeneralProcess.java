package com.z4knight.bugmanagement.dataobject;

import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/18 10:43
 *
 * 通用流转实体类
 */

@Data
public class GeneralProcess {

    private String uuid;

    private String objectId;

    private String objectType;

    private String objectName;

    private String procDefId;

    private String procInstId;

    private String taskId;

    private String executionId;

    private String taskName;

    private String procStatus;

    private String procDate;

    private String procUser;

    private String procResult;

    private String procDesp;

    private String procAssigner;

    private String register;

    private String modifier;

    private String createTime;

    private String editTime;

    @Override
    public String toString() {
        return "GeneralProcess{" +
                "uuid='" + uuid + '\'' +
                ", objectId='" + objectId + '\'' +
                ", objectType='" + objectType + '\'' +
                ", objectName='" + objectName + '\'' +
                ", procDefId='" + procDefId + '\'' +
                ", procInstId='" + procInstId + '\'' +
                ", taskId='" + taskId + '\'' +
                ", executionId='" + executionId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", procStatus='" + procStatus + '\'' +
                ", procDate='" + procDate + '\'' +
                ", procUser='" + procUser + '\'' +
                ", procResult='" + procResult + '\'' +
                ", procDesp='" + procDesp + '\'' +
                ", procAssigner='" + procAssigner + '\'' +
                ", register='" + register + '\'' +
                ", modifier='" + modifier + '\'' +
                ", createTime='" + createTime + '\'' +
                ", editTime='" + editTime + '\'' +
                '}';
    }
}
