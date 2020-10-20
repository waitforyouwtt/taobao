package com.yidiandian.vo;

import com.yidiandian.entity.UserHobby;
import com.yidiandian.enums.GenderEnum;
import com.yidiandian.enums.UserStatusEnum;
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
    private String  genderDesc;
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
    private String  statusDesc;

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
     * 校验码
     */
    private String verifyCode;

    /**
     * 绑定邮箱状态：0 未绑定 1已绑定
     */
    private Integer emailStatus;

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

    public void setGenderDesc() {
        this.genderDesc = GenderEnum.fromValue(gender).getMsg();
    }

    public String getGenderDesc() {
        return genderDesc = GenderEnum.fromValue(gender).getMsg();
    }

    public void setStatusDesc() {
        this.statusDesc = UserStatusEnum.fromValue(status).getMsg();
    }

    public String getStatusDesc() {
        return statusDesc = UserStatusEnum.fromValue(status).getMsg();
    }
}
