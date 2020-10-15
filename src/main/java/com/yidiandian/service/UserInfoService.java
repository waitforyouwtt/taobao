package com.yidiandian.service;

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
    int insertUserInfo(UserInfoVO userInfoVO);
}
