package com.yidiandian.view;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-16
 */
@Data
public class ScenicSpotView implements Serializable {

    /**
     * 发布景点动态关联主键
     */
    private Integer id;

    /**
     * 平台景点唯一码
     */
    private String  platformUniqueCode;

    /**
     * 景点名称
     */
    private String  scenicSpotName;

    /**
     * 主图
     */
    private String  mainImage;

    /**
     * 省份
     */
    private String  provinceCode;

    /**
     * 城市
     */
    private String  cityCode;
}
