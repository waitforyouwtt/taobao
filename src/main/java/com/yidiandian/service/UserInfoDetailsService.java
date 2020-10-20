package com.yidiandian.service;

import com.yidiandian.entity.UserInfoDetails;
import com.yidiandian.support.Result;
import com.yidiandian.vo.UserInfoVO;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-15
 */
public interface UserInfoDetailsService {

    /**
     * 保存用户详情信息
     */
    Result saveUserDetails(UserInfoVO userInfoVO,String userId);

    /**
     * 根据用户id 获取用户详情信息
     *
     */
    UserInfoDetails queryUserInfoDetails(String userId);

    /**
     * 修改用户信息
     * @param userInfoVO
     * @return
     */
    Result updateUserDetails(UserInfoVO userInfoVO);
}
