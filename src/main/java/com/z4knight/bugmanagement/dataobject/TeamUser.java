package com.z4knight.bugmanagement.dataobject;

import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/10 15:03
 *
 * 用户管理-小组用户实体类
 */
@Data
public class TeamUser {

    private String uuid;

    private String nickName;

    private String userName;

    private String userPswd;

    private String role;

    private String ownGroup;

    private String idNumber;

    private String email;

    private String mobile;

    private String register;

    private String modifier;

    private String createTime;

    private String editTime;


    @Override
    public String toString() {
        return "TeamUser{" +
                "uuid='" + uuid + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userName='" + userName + '\'' +
                ", userPswd='" + userPswd + '\'' +
                ", role='" + role + '\'' +
                ", ownGroup='" + ownGroup + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", register='" + register + '\'' +
                ", modifier='" + modifier + '\'' +
                ", createTime='" + createTime + '\'' +
                ", editTime='" + editTime + '\'' +
                '}';
    }
}
