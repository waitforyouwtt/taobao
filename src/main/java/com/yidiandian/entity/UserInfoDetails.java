package com.yidiandian.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户信息详情表(UserInfoDetails)实体类
 *
 * @author makejava
 * @since 2020-10-15 09:47:13
 */
@Data
public class UserInfoDetails implements Serializable {
    private static final long serialVersionUID = 246038505552540131L;
    /**
    * 自增id
    */
    private Integer id;
    /**
    * 用户id
    */
    private String userId;
    /**
    * 用户生日
    */
    private Date birthday;
    /**
    * 绑定手机号
    */
    private String phone;
    /**
    * 绑定邮箱
    */
    private String email;
    /**
    * 绑定微信
    */
    private String wechat;
    /**
    * 家庭住址
    */
    private String familyAddress;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;

}