package com.yidiandian.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 景点景区图片集合表(ScenicSpotImages)实体类
 *
 * @author makejava
 * @since 2020-10-15 17:11:26
 */
@Data
public class ScenicSpotImages implements Serializable {
    private static final long serialVersionUID = 649505080703587845L;
    /**
    * 自增id
    */
    private Integer id;
    /**
    * 关联主键
    */
    private Integer scenicSpotInfoId;
    /**
    * 图片
    */
    private String image;
    /**
    * 用户id
    */
    private String userId;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;
}