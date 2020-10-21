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
public class UserDynamicVO implements Serializable {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 标题
     */
    private String title;

    private String provinceCode;
    private String cityCode;
    /**
     * 主图
     */
    private String mainImage;

    /**
     * 图片的集合
     */
    List<ScenicSpotImages> imagesList;

    /**
     * 主图地址
     */
    MultipartFile main;

    /**
     * 附图
     */
    MultipartFile[] files;
}
