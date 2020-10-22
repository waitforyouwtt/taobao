package com.yidiandian.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 当地特产合作商家表(LocalSpecialtyBusiness)实体类
 *
 * @author makejava
 * @since 2020-10-22 16:15:11
 */
@Data
public class LocalSpecialtyBusiness implements Serializable {

    private static final long serialVersionUID = 591866492909837555L;
    /**
    * 自增id
    */
    private Integer id;
    /**
    * 特产商品code
    */
    private String productCode;
    /**
    * 商家id
    */
    private String businessId;
    /**
    * 商家门店名称
    */
    private String businessName;
    /**
    * 商家门店联系电话
    */
    private String businessPhone;
    /**
    * 商家地址
    */
    private String businessAddress;
    /**
     * 营业时间
     */
    private String businessHours;
    /**
    * 商家状态：0 正在营业 2停业
    */
    private Integer businessStatus;
    /**
    * 热卖商品
    */
    private String productHotSell;
    /**
    * 热卖商品价格
    */
    private Double productHotSellPrice;
    /**
    * 商家level
    */
    private Integer businessLevel;
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