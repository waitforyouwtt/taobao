package com.yidiandian.service.impl;

import com.yidiandian.dao.UserHobbyDao;
import com.yidiandian.entity.UserHobby;
import com.yidiandian.service.UserHobbyService;
import com.yidiandian.support.Result;
import com.yidiandian.vo.UserInfoVO;
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
public class UserHobbyServiceImpl implements UserHobbyService {

    @Resource
    UserHobbyDao userHobbyDao;

    @Override
    public int insertUserHobby(UserInfoVO userInfoVO, String userId) {
        return CollectionUtils.isEmpty(structureUserHobby(userInfoVO,userId)) ? 0 : userHobbyDao.batchInsertHobby(structureUserHobby(userInfoVO,userId)) ;
    }

    @Override
    public List<UserHobby> findUserHobbyListByUserId(String userId) {
        UserHobby vo = new UserHobby();
        vo.setUserId(userId);
        return userHobbyDao.queryAll(vo);
    }

    @Override
    public int updateUserHobby(UserInfoVO userInfoVO) {
        if (org.apache.commons.collections4.CollectionUtils.isEmpty(userInfoVO.getHobbyList())){
            return 0;
        }
        userHobbyDao.deleteByUserId(userInfoVO.getUserId());
        return userHobbyDao.batchInsertHobby(structureUserHobby(userInfoVO,userInfoVO.getUserId()));
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
