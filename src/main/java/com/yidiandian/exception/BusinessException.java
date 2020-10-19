package com.yidiandian.exception;

import lombok.Getter;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-19
 */
@Getter
public class BusinessException extends RuntimeException {

    private Integer code;
    private String  msg ;

    public BusinessException(String msg){
        super(msg);
    }
    public BusinessException(Integer code, String msg){
        super(msg);
        this.code = code;
        this.msg  = msg;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
}
