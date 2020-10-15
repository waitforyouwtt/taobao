package com.yidiandian.service.impl;

import cn.hutool.json.JSONUtil;
import com.yidiandian.dao.UserHobbyDao;
import com.yidiandian.dao.UserInfoDao;
import com.yidiandian.dao.UserInfoDetailsDao;
import com.yidiandian.entity.UserHobby;
import com.yidiandian.entity.UserInfo;
import com.yidiandian.entity.UserInfoDetails;
import com.yidiandian.service.UserInfoService;
import com.yidiandian.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author 凤凰小哥哥
 * @date 2020-10-15
 */
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoDao userInfoDao;
    @Resource
    UserInfoDetailsDao userInfoDetailsDao;
    @Resource
    UserHobbyDao userHobbyDao;

    @Override
    public int insertUserInfo(UserInfoVO userInfoVO) {
        log.info("添加用户信息请求参数：{}", JSONUtil.parseObj(userInfoVO));
        String userId = RandomStringUtils.randomAlphanumeric(8);
        int insertUserInfo = userInfoDao.insert(structureUserInfo(userInfoVO,userId));
        int insertDetails = userInfoDetailsDao.insert(structureUserInfoDetails(userInfoVO,userId));
        int insertHobby = CollectionUtils.isEmpty(structureUserHobby(userInfoVO,userId)) ? 0 : userHobbyDao.batchInsertHobby(structureUserHobby(userInfoVO,userId)) ;
        return insertUserInfo > 0 ? 1 : 0 ;
    }

    private UserInfo structureUserInfo(UserInfoVO userInfoVO,String userId){
        UserInfo userInfo = new UserInfo();
        BeanCopier beanCopier = BeanCopier.create(UserInfoVO.class,UserInfo.class,false);
        beanCopier.copy(userInfoVO,userInfo,null);
        userInfo.setUserId(userId);
        return userInfo;
    }
    private UserInfoDetails structureUserInfoDetails(UserInfoVO userInfoVO,String userId){
        UserInfoDetails userInfoDetails = new UserInfoDetails();
        BeanCopier beanCopier = BeanCopier.create(UserInfoVO.class,UserInfoDetails.class,false);
        beanCopier.copy(userInfoVO,userInfoDetails,null);
        userInfoDetails.setUserId(userId);
        return userInfoDetails;
    }

    private List<UserHobby> structureUserHobby(UserInfoVO userInfoVO, String userId){
        if (CollectionUtils.isEmpty(userInfoVO.getHobbyList()) ){
            return Collections.EMPTY_LIST;
        }
        List<UserHobby> userHobbies = new ArrayList<>();
        userInfoVO.getHobbyList().stream().forEach(vo->{
            UserHobby userHobby = new UserHobby();
            BeanCopier beanCopier = BeanCopier.create(UserInfoVO.class,UserHobby.class,false);
            beanCopier.copy(userInfoVO,userHobby,null);
            userHobby.setHobby(vo.getHobby());
            userHobby.setUserId(userId);
            userHobbies.add(userHobby);
        });
        return userHobbies;
    }
}
