package com.yidiandian.dao;

import com.yidiandian.entity.UserInfo;
import com.yidiandian.view.UserInfoView;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/5 22:29
 * @Email: 15290810931@163.com
 */
@Mapper
public interface UserInfoDao {

    UserInfo findUser(UserInfoView view);
}
