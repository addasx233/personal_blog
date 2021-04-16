package com.yamlapkei.view;

import com.mysql.jdbc.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class Result {
    //状态码 成功000000 失败999999
    private String code;
    private String message;
    private Map<String, Object> data = new HashMap<String, Object>();

    public static Result success() {
        Result result = new Result();
        result.setCode("000000");
        result.setMessage("success!!!");
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setCode("999999");
        if (StringUtils.isNullOrEmpty(msg)) {
            result.setMessage("操作失败");
        } else {
            result.setMessage(msg);
        }
        return result;
    }

    public Result add(String key,String value){
        data.put(key,value);
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
