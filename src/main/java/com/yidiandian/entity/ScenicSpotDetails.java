package com.yidiandian.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 景点景区详情表(ScenicSpotDetails)实体类
 *
 * @author makejava
 * @since 2020-10-15 17:09:50
 */
@Data
public class ScenicSpotDetails implements Serializable {
    private static final long serialVersionUID = 146893193768357409L;
    /**
    * 自增id
    */
    private Integer id;
    /**
    * 景点景区关联id
    */
    private Integer scenicSpotInfoId;
    /**
    * 标题
    */
    private String title;
    /**
    * 景点故事
    */
    private String story;
    /**
    * 主图
    */
    private String mainImage;
    /**
    * 定位地点
    */
    private String locationName;
    /**
    * 经度
    */
    private String locationLatitude;
    /**
    * 纬度
    */
    private String locationLongitude;
    /**
    * 创建人
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