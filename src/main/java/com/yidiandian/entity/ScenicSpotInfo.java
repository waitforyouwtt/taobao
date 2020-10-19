package com.yidiandian.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 景点景区表(ScenicSpotInfo)实体类
 *
 * @author makejava
 * @since 2020-10-15 17:07:50
 */
@Data
public class ScenicSpotInfo implements Serializable {
    private static final long serialVersionUID = 187470020755470235L;
    /**
    * 自增id
    */
    private Integer id;
    /**
     * 平台景点唯一码
     */
    private String platformUniqueCode;
    /**
    * 景点名称
    */
    private String scenicSpotName;
    /**
    * 景点描述
    */
    private String scenicSpotDescribe;
    /**
    * 所在省份
    */
    private String provinceCode;
    /**
    * 所在城市
    */
    private String cityCode;
    /**
    * AAAAA景点
    */
    private String starLevel;
    /**
    * 热度
    */
    private String hotLevel;
    /**
    * 发布人id
    */
    private String userId;
    /**
    * 发布时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;
    /**
    * 景点状态：0正常，1 停业

    */
    private Integer status;
    /**
    * 动态状态:  0 正常 1 删除
    */
    private Integer pulishStatus;

}