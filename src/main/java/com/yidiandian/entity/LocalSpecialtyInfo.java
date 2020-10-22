package com.yidiandian.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 当地特产信息表(LocalSpecialtyInfo)实体类
 *
 * @author makejava
 * @since 2020-10-22 16:15:50
 */
@Data
public class LocalSpecialtyInfo implements Serializable {

    private static final long serialVersionUID = 243037020362401959L;
    /**
    * 自增id
    */
    private Integer id;
    /**
    * 特产商品code
    */
    private String productCode;
    /**
    * 特产商品名称
    */
    private String productName;
    /**
    * 特产商品主图
    */
    private String productImage;
    /**
    * 省份code
    */
    private String provinceCode;
    /**
    * 城市code
    */
    private String cityCode;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;
    /**
    * 创建人
    */
    private String createBy;

}