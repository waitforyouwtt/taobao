package com.yidiandian.exception;

import com.yidiandian.enums.SystemCodeEnum;
import com.yidiandian.support.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-19
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result defaultException(HttpServletRequest request, Exception e){
        e.printStackTrace();
        Result result = new Result();
        result.setFlag(false);
        result.setCode(SystemCodeEnum.EXCEPTION.getCode());
        result.setMessage(SystemCodeEnum.EXCEPTION.getMsg());
        result.setData(null);
        return result;
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Result myException(HttpServletRequest request, BusinessException e){
        e.printStackTrace();
        Integer code = e.getCode();
        String msg = e.getMessage();
        if (e.getCode() == null){
            code = SystemCodeEnum.EXCEPTION.getCode();
        }
        if (e.getMessage() == null){
            msg = SystemCodeEnum.EXCEPTION.getMsg();
        }
        Result result = new Result();
        result.setFlag(false);
        result.setCode(code);
        result.setMessage(msg);
        result.setData(null);
        return result;
    }
}
