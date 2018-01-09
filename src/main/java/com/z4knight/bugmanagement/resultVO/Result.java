package com.z4knight.bugmanagement.resultVO;
import com.alibaba.fastjson.JSON;
import com.z4knight.bugmanagement.enums.ResultCode;


/**
 * @Author Z4knight
 * @Date 2017/12/27 14:53
 *
 * 返回信息类
 * 按照接口设计，返回对应信息给前端
 */
public class Result {

    private int code;
    private String message;
    private Object data;

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
