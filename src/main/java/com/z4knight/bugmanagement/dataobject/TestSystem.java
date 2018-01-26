package com.z4knight.bugmanagement.dataobject;

import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/10 15:20
 *
 * 基础功能-被测系统实体类
 */
@Data
public class TestSystem {

    private String systemId;

    private Integer open;

    private String systemName;

    private String testDirector;

    private String devDirector;

    private String versionNumber;

    private String description;

    private String note;

    private String register;

    private String modifier;

    private String createTime;

    private String editTime;

    @Override
    public String toString() {
        return "TestSystem{" +
                "systemId='" + systemId + '\'' +
                ", open=" + open +
                ", systemName='" + systemName + '\'' +
                ", testDirector='" + testDirector + '\'' +
                ", devDirector='" + devDirector + '\'' +
                ", versionNumber='" + versionNumber + '\'' +
                ", description='" + description + '\'' +
                ", note='" + note + '\'' +
                ", register='" + register + '\'' +
                ", modifier='" + modifier + '\'' +
                ", createTime='" + createTime + '\'' +
                ", editTime='" + editTime + '\'' +
                '}';
    }
}
