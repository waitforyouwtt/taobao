package com.yidiandian.support;

import com.yidiandian.enums.SystemCodeEnum;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-19
 */
@Data
@ApiModel
public class Result<T> {

    private boolean flag = true;
    private Integer code;
    private String message;
    private T data;

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result(boolean flag, Integer code, String message, T data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result() {
    }
    public static <T> Result<T> success(T data) {
        Result<T> response = new Result();
        response.setCode(SystemCodeEnum.SUCCESS.getCode());
        response.setMessage(SystemCodeEnum.SUCCESS.getMsg());
        response.setData(data);
        return response;
    }
    public static <T> Result<T> success() {
        Result<T> response = new Result();
        response.setCode(SystemCodeEnum.SUCCESS.getCode());
        response.setMessage(SystemCodeEnum.SUCCESS.getMsg());
        response.setData(null);
        return response;
    }
    public static <T> Result<T> error(T data) {
        Result<T> response = new Result();
        response.setCode(SystemCodeEnum.ERROR.getCode());
        response.setMessage(SystemCodeEnum.ERROR.getMsg());
        response.setData(data);
        return response;
    }

    public static <T> Result<T> error() {
        Result<T> response = new Result();
        response.setCode(SystemCodeEnum.ERROR.getCode());
        response.setMessage(SystemCodeEnum.ERROR.getMsg());
        response.setData(null);
        return response;
    }

    public static <T> Result<T> error(Integer code,String message,T data) {
        Result<T> response = new Result();
        response.setCode(code);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
