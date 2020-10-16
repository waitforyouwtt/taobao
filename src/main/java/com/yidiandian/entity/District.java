package com.yidiandian.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 中国行政区划代码表
数据时间：2019年11月
数据来源：http://www.mca.gov.cn/article/sj/xzqh(District)实体类
 *
 * @author makejava
 * @since 2020-10-16 18:36:33
 */
@Data
public class District implements Serializable {
    private static final long serialVersionUID = 727222043635464325L;
    /**
    * 地区编码
    */
    private int id;
    /**
    * 地区名称
    */
    private String name;
    /**
    * 行政级别
    */
    private int level;
    /**
    * 上级地区编码
    */
    private int upid;

}