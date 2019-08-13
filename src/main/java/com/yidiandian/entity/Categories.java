package com.yidiandian.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/5 23:27
 * @Email: 15290810931@163.com
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Builder
@Table(name ="tb_categories")
@org.hibernate.annotations.Table(appliesTo = "tb_categories",comment="类目标")
public class Categories {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "parent_id",columnDefinition="varchar(50) COMMENT '父级ID'")
    private String parentId;

    @Basic
    @Column(name = "categories_name",columnDefinition="varchar(50) COMMENT '类名字'")
    private String categoriesName;

    @Basic
    @Column(name = "categories_link_url",columnDefinition="varchar(100) COMMENT '类连接'")
    private String categoriesLinkUrl ;
}
