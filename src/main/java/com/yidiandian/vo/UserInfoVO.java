package com.yidiandian.vo;

import com.yidiandian.entity.UserHobby;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-15
 */
@Data
public class UserInfoVO {
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户昵称
     */
    private String userNick;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户性别：0 男 1 女 2保密
     */
    private Integer gender;
    /**
     * 用户头像
     */
    private String headImage;
    /**
     * 用户手机号
     */
    private String phone;
    /**
     * 用户状态：0 正常 1 禁用
     */
    private Integer status;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户生日
     */
    private Date birthday;

    /**
     * 绑定邮箱
     */
    private String email;
    /**
     * 绑定微信
     */
    private String wechat;
    /**
     * 家庭住址
     */
    private String familyAddress;
    /**
     * 用户爱好
     */
    private List<UserHobby> hobbyList;
}
