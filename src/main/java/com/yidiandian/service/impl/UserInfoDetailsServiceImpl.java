package com.yidiandian.service.impl;

import com.yidiandian.dao.UserInfoDetailsDao;
import com.yidiandian.entity.UserInfoDetails;
import com.yidiandian.service.UserInfoDetailsService;
import com.yidiandian.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-15
 */

@Service
@Slf4j
public class UserInfoDetailsServiceImpl implements UserInfoDetailsService {

    @Resource
    UserInfoDetailsDao userInfoDetailsDao;

    @Override
    public int insertDetails(UserInfoVO userInfoVO, String userId) {
        return userInfoDetailsDao.insert(structureUserInfoDetails(userInfoVO,userId));
    }

    @Override
    public UserInfoDetails queryUserInfoDetails(String userId) {
        UserInfoDetails details = new UserInfoDetails();
        details.setUserId(userId);
        List<UserInfoDetails> userInfoDetailsList = userInfoDetailsDao.queryAll(details);
        if (CollectionUtils.isEmpty(userInfoDetailsList)){
            return null;
        }
        return userInfoDetailsList.get(0);
    }


    private UserInfoDetails structureUserInfoDetails(UserInfoVO userInfoVO,String userId){
        UserInfoDetails userInfoDetails = new UserInfoDetails();
        BeanCopier beanCopier = BeanCopier.create(UserInfoVO.class,UserInfoDetails.class,false);
        beanCopier.copy(userInfoVO,userInfoDetails,null);
        userInfoDetails.setUserId(userId);
        return userInfoDetails;
    }
}
