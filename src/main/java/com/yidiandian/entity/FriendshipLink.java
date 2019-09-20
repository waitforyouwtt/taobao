package com.yidiandian.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 16:04
 * @Email: 15290810931@163.com
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Builder
@Table(name ="tb_friendship_link")
@org.hibernate.annotations.Table(appliesTo = "tb_friendship_link",comment="底部友情链接表")
public class FriendshipLink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Basic
    @Column(name = "friendship_name",columnDefinition="varchar(100) COMMENT '友情链接名字'")
    private String friendshipName;

    @Basic
    @Column(name = "friendship_url",columnDefinition="varchar(255) COMMENT '友情链接url'")
    private String friendshipUrl;

    @Basic
    @Column(name = "status",columnDefinition="int(11) COMMENT '友情链接状态：1 有效 0 失效'")
    private Integer status;

}
