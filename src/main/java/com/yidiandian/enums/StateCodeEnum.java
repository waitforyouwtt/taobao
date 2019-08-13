package com.yidiandian.enums;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/13 15:44
 * @Email: 15290810931@163.com
 */
public enum StateCodeEnum {
    OK(2000,"成功"),
    ERROR(2001,"失败"),
    LOGIN_ERROR(2002,"用户名或密码错误"),
    ACCESS_ERROR(2003,"权限不足"),
    REMOTE_ERROR(2004,"远程调用错误"),
    REP_ERROR(2005,"重复操作"),
    PARAMS_NOT_POINT(2006,"参数为空"),
    QUERRY_ERROR(2007,"查询错误");

    StateCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String  message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
