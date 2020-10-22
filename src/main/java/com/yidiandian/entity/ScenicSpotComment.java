package com.yidiandian.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 景点景区评论表(ScenicSpotComment)实体类
 *
 * @author makejava
 * @since 2020-10-22 11:00:17
 */
@Data
public class ScenicSpotComment implements Serializable {
    private static final long serialVersionUID = -62630029314351779L;
    /**
    * 自增id
    */
    private Integer id;
    /**
    * 关联主键
    */
    private Integer scenicSpotInfoId;
    /**
    * 评论描述
    */
    private String comment;
    /**
    * 评论人id
    */
    private String userId;
    /**
    * 评论创建时间
    */
    private Date createTime;
    /**
    * 评论修改时间
    */
    private Date updateTime;

}