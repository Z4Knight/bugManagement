package com.z4knight.bugmanagement.form;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @Author Z4knight
 * @Date 2018/2/1 10:42
 *
 * 查询流转信息请求类
 */

@Data
@JsonSerialize
public class ProcessForm {

    private String objectId;

    private String objectType;

}
