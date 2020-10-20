package com.yidiandian.service;

import com.yidiandian.entity.UserInfo;
import com.yidiandian.support.Result;
import com.yidiandian.view.UserInfoView;
import com.yidiandian.vo.UserInfoVO;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-15
 */
public interface UserInfoService {

    /**
     * 保存用户相关信息
     * @param userInfoVO
     * @return
     */
    Result insertUserInfo(UserInfoVO userInfoVO);

    /**
     * 通过用户名查询用户信息
     * @param userName
     * @return
     */
    UserInfo findUserInfoByUserName(String userName);

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    Result findUserInfo(String token);

    /**
     * 用户修改自己的个人信息
     * @param userInfoVO
     * @return
     */
    Result updateUserInfo(UserInfoVO userInfoVO);
}
