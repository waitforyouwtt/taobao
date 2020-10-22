package com.yidiandian.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 景点景区点赞表(ScenicSpotStar)实体类
 *
 * @author makejava
 * @since 2020-10-22 10:59:51
 */
@Data
public class ScenicSpotStar implements Serializable {
    private static final long serialVersionUID = 154868162236111227L;
    /**
    * 自增id
    */
    private Integer id;
    /**
    * 关联id
    */
    private Integer scenicSpotInfoId;
    /**
    * 点赞:0 点赞 1 取消点赞
    */
    private String star;
    /**
    * 点赞人id
    */
    private String userId;
    /**
    * 点赞时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;

}