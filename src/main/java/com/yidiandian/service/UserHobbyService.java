package com.yidiandian.service;

import com.yidiandian.entity.UserHobby;
import com.yidiandian.vo.UserInfoVO;
import java.util.List;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-15
 */
public interface UserHobbyService {

    /**
     * 保存用户爱好
     * @return
     */
    int insertUserHobby(UserInfoVO userInfoVO, String userId);

    /**
     * 根据用户ID 获取用户爱好集合
     * @param userId
     * @return
     */
    List<UserHobby> findUserHobbyListByUserId(String userId);
}
