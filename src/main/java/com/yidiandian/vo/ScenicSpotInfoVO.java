package com.yidiandian.vo;

import com.yidiandian.entity.ScenicSpotImages;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-15
 */
@Data
public class ScenicSpotInfoVO implements Serializable {

    /**
     * 平台景点唯一码
     */
    private String platformUniqueCode;

    /**
     * 发布景点动态关联主键
     */
    private int scenicSpotInfoId;

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
     * 标题
     */
    private String title;
    /**
     * 景点故事
     */
    private String story;
    /**
     * 主图图片url
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
     * 附图图片url集合
     */
    List<ScenicSpotImages> imagesList;

    /**
     * 主图接收文件
     */
    MultipartFile main;

    /**
     * 附图接收文件
     */
    MultipartFile[] files;
}
