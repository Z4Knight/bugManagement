package com.z4knight.bugmanagement.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/30 13:45
 *
 * 小组用户-前端展示类
 */

@Data
@JsonSerialize
public class TeamUserVO {

    private String userName;

    private String nickName;

    private String role;

}
