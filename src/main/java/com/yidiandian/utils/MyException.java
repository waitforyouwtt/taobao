package com.yidiandian.utils;

import lombok.Data;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/13 15:53
 * @Email: 15290810931@163.com
 */
@Data
public class MyException extends RuntimeException {

    private Integer code;
    public MyException(String msg){
        super(msg);
    }
    public MyException(Integer code, String msg){
        super(msg);
        this.code = code;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
}
