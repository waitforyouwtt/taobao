package com.yidiandian.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * on Travel 日志记录表(TravelLog)实体类
 *
 * @author makejava
 * @since 2020-10-20 15:32:21
 */
@Data
public class TravelLog implements Serializable {
    private static final long serialVersionUID = -32016109775544687L;
    /**
    * 自增主键
    */
    private Integer id;
    /**
    * 用户id
    */
    private String userId;
    /**
    * 用户姓名
    */
    private String userName;
    /**
    * 用户手机号
    */
    private String mobile;
    /**
    * 用户邮箱
    */
    private String email;
    /**
    * 用户微信
    */
    private String wechat;
    /**
    * 验证码
    */
    private String code;
    /**
    * 日志类型：0 用户注册
    */
    private Integer logType;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;

}