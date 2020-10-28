package com.yidiandian.entity;

import com.yidiandian.enums.GenderEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.io.Serializable;

/**
 * 用户信息表(UserInfo)实体类
 *
 * @author makejava
 * @since 2020-10-15 09:43:17
 */

@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -44439829619031273L;
    
    private Integer id;
    /**
    * 用户id
    */
    private String userId;
    /**
    * 用户姓名
    */
    @NotBlank(message = "用户名不能为空")
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
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;

    public void setGenderDesc() {
        this.genderDesc = GenderEnum.fromValue(gender).getMsg();
    }

    public String getGenderDesc() {
        return genderDesc = GenderEnum.fromValue(gender).getMsg();
    }

}