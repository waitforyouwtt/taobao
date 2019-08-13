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

    private String userName;

    private String nickName;

    private String password;

    private Integer age;

    private String address;


}
