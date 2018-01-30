package com.z4knight.bugmanagement.form;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/1/29 15:35
 *
 * 开启关闭前端请求类
 */

@JsonSerialize
@Data
public class OpenClose {

    private Integer open;

    private String id;

    @Override
    public String toString() {
        return "OpenClose{" +
                "open='" + open + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
