package com.yidiandian.entity;

import com.yidiandian.enums.HobbyEnum;
import lombok.Data;
import java.util.Date;
import java.io.Serializable;

/**
 * 用户爱好表(UserHobby)实体类
 *
 * @author makejava
 * @since 2020-10-15 09:49:28
 */
@Data
public class UserHobby implements Serializable {
    private static final long serialVersionUID = -50098774491454479L;
    /**
    * 自增id
    */
    private Integer id;
    /**
    * 用户id
    */
    private String userId;
    /**
    * 用户爱好
    */
    private Integer hobby;
    private String hobbyDesc;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;

    public void setHobbyDesc() {
        this.hobbyDesc = HobbyEnum.fromValue(hobby).getMsg();
    }

    public String getHobbyDesc() {
        return hobbyDesc = HobbyEnum.fromValue(hobby).getMsg();
    }
}