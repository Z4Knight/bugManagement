package com.z4knight.bugmanagement.dataobject;

import lombok.Data;


/**
 * @Author Z4knight
 * @Date 2018/1/5 16:12
 *
 * 基础功能-项目组的实体类
 */

@Data
public class ProjectGroup {

    private String groupId;

    private Integer open;

    private String groupName;

    private String groupManager;

    private String note;

    private String register;

    private String modifier;

    private String createTime;

    private String editTime;
}
