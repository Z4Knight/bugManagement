package com.z4knight.bugmanagement.dataobject;

import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/22 10:44
 *
 * 流转记录实体类
 */

@Data
public class HistoricProcess {

    private String uuid;

    private String objectId;

    private String taskName;

    private String taskId;

    private String createTime;

    private String procTime;

    private String procUser;

    private String procAssigner;

    private String procResult;

    private String procDesp;


    @Override
    public String toString() {
        return "HistoricProcess{" +
                "uuid='" + uuid + '\'' +
                ", objectId='" + objectId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskId='" + taskId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", procTime='" + procTime + '\'' +
                ", procUser='" + procUser + '\'' +
                ", procAssigner='" + procAssigner + '\'' +
                ", procResult='" + procResult + '\'' +
                ", procDesp='" + procDesp + '\'' +
                '}';
    }
}
