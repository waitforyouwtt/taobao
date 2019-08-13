package com.yidiandian.enums;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/13 16:04
 * @Email: 15290810931@163.com
 */
public enum CategoriesOperationTypeEnum {

    add(1,"增加"),
    delete(2,"删除"),
    update(3,"修改");

    CategoriesOperationTypeEnum(Integer code, String message) {
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
