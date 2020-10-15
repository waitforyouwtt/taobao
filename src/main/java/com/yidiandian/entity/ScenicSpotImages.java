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
    * 主图
    */
    private String mainImage;
    /**
    * 附图1
    */
    private String image1;
    /**
    * 附图2
    */
    private String image2;
    /**
    * 附图3
    */
    private String image3;
    /**
    * 附图4
    */
    private String image4;
    /**
    * 附图5
    */
    private String image5;
    /**
    * 附图6
    */
    private String image6;
    /**
    * 附图7
    */
    private String image7;
    /**
    * 附图8
    */
    private String image8;
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