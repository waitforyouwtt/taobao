package com.yidiandian.service;

import com.yidiandian.entity.UserInfoDetails;
import com.yidiandian.vo.UserInfoVO;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-15
 */
public interface UserInfoDetailsService {

    /**
     * 添加用户详情信息
     */
    int insertDetails(UserInfoVO userInfoVO,String userId);

    /**
     * 根据用户id 获取用户详情信息
     *
     */
    UserInfoDetails queryUserInfoDetails(String userId);
}
