package com.yidiandian.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/5 22:33
 * @Email: 15290810931@163.com
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Builder
@Table(name ="tb_user_info")
@org.hibernate.annotations.Table(appliesTo = "tb_user_info",comment="用户表")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Basic
    @Column(name = "user_name",columnDefinition="varchar(50) COMMENT '用户名'")
    private String userName;

    @Basic
    @Column(name = "nick_name",columnDefinition="varchar(50) COMMENT '用户昵称'")
    private String nickName;

    @Basic
    @Column(name = "password",columnDefinition="varchar(200) COMMENT '用户密码'")
    private String password;

    @Basic
    @Column(name = "age",columnDefinition="int(11) COMMENT '用户年龄'")
    private Integer age;

    @Basic
    @Column(name = "address",columnDefinition="varchar(200) COMMENT '用户地址'")
    private String address;


}
