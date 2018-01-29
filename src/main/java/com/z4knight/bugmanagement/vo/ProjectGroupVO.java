package com.z4knight.bugmanagement.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/29 17:28
 *
 * 小组管理前端展示类
 */
@JsonSerialize
@Data
public class ProjectGroupVO {

    private String groupId;

    private Boolean open;

    private String groupName;

    private String groupManager;

    private String note;

    private String register;

    private String modifier;

    private String createTime;

    private String editTime;
}
