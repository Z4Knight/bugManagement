package com.z4knight.bugmanagement.dataobject;

import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/10 15:03
 *
 * 用户管理-小组用户实体类
 */
@Data
public class ManageUser {

    private String uuid;

    private String loginName;

    private String userName;

    private String role;

    private String institution;

    private String groupName;

    @Override
    public String toString() {
        return "ManageUser{" +
                "uuid='" + uuid + '\'' +
                ", loginName='" + loginName + '\'' +
                ", userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                ", institution='" + institution + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
