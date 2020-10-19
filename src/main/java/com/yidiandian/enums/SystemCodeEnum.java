package com.yidiandian.enums;

import lombok.Getter;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-19
 */
@Getter
public enum SystemCodeEnum {

    SUCCESS(200,"成功"),
    ERROR(201,"失败"),
    ACCESS_ERROR(401,"权限不足"),
    EXCEPTION(500,"系统异常"),
    ;

    SystemCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String  msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
