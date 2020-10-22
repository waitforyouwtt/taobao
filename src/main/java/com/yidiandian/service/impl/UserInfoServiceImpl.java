package com.yidiandian.service.impl;

import cn.hutool.json.JSONUtil;
import com.yidiandian.dao.UserInfoDao;
import com.yidiandian.entity.ScenicSpotInfo;
import com.yidiandian.entity.UserHobby;
import com.yidiandian.entity.UserInfo;
import com.yidiandian.entity.UserInfoDetails;
import com.yidiandian.service.*;
import com.yidiandian.support.Result;
import com.yidiandian.utils.GenerateCodeUtils;
import com.yidiandian.view.UserInfoView;
import com.yidiandian.vo.ScenicSpotStarVO;
import com.yidiandian.vo.UserDynamicVO;
import com.yidiandian.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.annotation.Resource;
import javax.persistence.RollbackException;
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

    @Autowired
    UserInfoDetailsService userInfoDetailsService;

    @Autowired
    UserHobbyService userHobbyService;

    @Autowired
    ScenicSpotInfoService scenicSpotInfoService;

    @Autowired
    private ScenicSpotDetailsService scenicSpotDetailsService;

    @Autowired
    private ScenicSpotImagesService scenicSpotImagesService;

    @ExceptionHandler(RollbackException.class)
    @Override
    public Result insertUserInfo(UserInfoVO userInfoVO) {
        log.info("添加用户信息请求参数：{}", JSONUtil.parseObj(userInfoVO));
        if (findUserInfoByUserName(userInfoVO.getUserName()) != null){
          return Result.error("您已经是平台用户，请勿重复注册");
        }
        String userId = RandomStringUtils.randomAlphanumeric(8);
        int insertUserInfo = userInfoDao.insert(structureUserInfo(userInfoVO,userId));
        if (StringUtils.isNotBlank(userInfoVO.getEmail())){
            //获取激活码
            String code = GenerateCodeUtils.generateEmailCode();
            userInfoVO.setVerifyCode(code);
        }
        userInfoDetailsService.saveUserDetails(userInfoVO,userId);
        userHobbyService.insertUserHobby(userInfoVO,userId);
        return insertUserInfo > 0 ? Result.success() : Result.error() ;
    }

    @Override
    public UserInfo findUserInfoByUserName(String userName) {
        log.info("通过用户名查询用户信息请求参数：{}",userName);
        return userInfoDao.findUserInfoByName(userName);
    }

    @Override
    public Result findUserInfo(String token) {
        log.info("根据token获取用户信息请求参数：{}",token);
        String userId = token;

        if (StringUtils.isBlank(userId)){
           return Result.success();
        }
        return Result.success(structureUserInfoView(userId));
    }

    @Override
    public Result updateUserInfo(UserInfoVO userInfoVO) {
        log.info("用户修改自己的个人信息请求参数：{}",JSONUtil.parseObj(userInfoVO));
        int updateUser = userInfoDao.update(structureUpdate(userInfoVO));
        int updateDetail = userInfoDetailsService.updateUserDetails(userInfoVO);
        int updateHobby = userHobbyService.updateUserHobby(userInfoVO);
        return (updateUser >0 || updateDetail > 0 || updateHobby > 0 ) ? Result.success("操作成功") : Result.error("操作失败");
    }

    @Override
    public Result publishDynamic(UserDynamicVO userDynamicVO) {
        log.info("用户发布个人动态请求参数：{}", JSONUtil.parseObj(userDynamicVO));
        Result<List<ScenicSpotInfo>> spotInfoLikeTitle = scenicSpotInfoService.findSpotInfoLikeTitle(userDynamicVO.getTitle());
        List<ScenicSpotInfo> spotList = spotInfoLikeTitle.getData();
        //判断平台是否已经录入该景点景区：未录入，则插入三张表。已录入，则插入两张表
        if (org.apache.commons.collections4.CollectionUtils.isEmpty(spotList)) {
            int scenicSpotInfoId = scenicSpotInfoService.publishDynamic(userDynamicVO);
            int insertScenicSpotDetails = scenicSpotDetailsService.publishDynamic(userDynamicVO, scenicSpotInfoId);
            int insertSpotImages = scenicSpotImagesService.publishDynamic(userDynamicVO, scenicSpotInfoId);
            return (scenicSpotInfoId > 0 && insertScenicSpotDetails > 0 && insertSpotImages > 0) ? Result.success("操作成功") : Result.error("操作失败");
        }
        int insertScenicSpotDetails = scenicSpotDetailsService.publishDynamic(userDynamicVO, spotList.get(0).getId());
        int insertSpotImages = scenicSpotImagesService.publishDynamic(userDynamicVO, spotList.get(0).getId());
        return (insertScenicSpotDetails > 0 && insertSpotImages > 0) ? Result.success("操作成功") : Result.error("操作失败");
    }

    @Override
    public Result deleteDynamic(UserDynamicVO vo) {
        int deleteSpot = scenicSpotInfoService.deleteUserDynamic(vo);
        int deleteSpotDetails = scenicSpotDetailsService.deleteUserDynamic(vo);
        int deleteImages = scenicSpotImagesService.deleteUserDynamic(vo);
        return (deleteSpot > 0 || deleteSpotDetails > 0 || deleteImages >0) ? Result.success("操作成功") : Result.error("操作失败");
    }

    private UserInfo structureUpdate(UserInfoVO vo){
        UserInfo info = new UserInfo();
        BeanCopier beanCopier = BeanCopier.create(UserInfoVO.class,UserInfo.class,false);
        beanCopier.copy(vo,info,null);
        info.setUserName(null);
        return info;
    }

    private UserInfoView structureUserInfoView(String userId){
        UserInfoView view = new UserInfoView();
        UserInfo userInfo = userInfoDao.queryByUserId(userId);
        UserInfoDetails userInfoDetails = userInfoDetailsService.queryUserInfoDetails(userId);
        List<UserHobby> userHobbyList = userHobbyService.findUserHobbyListByUserId(userId);
        BeanCopier copier1 = BeanCopier.create(UserInfo.class,UserInfoView.class,false);
        copier1.copy(userInfo,view,null);

        BeanCopier copier2 = BeanCopier.create(UserInfoDetails.class,UserInfoView.class,false);
        copier2.copy(userInfoDetails,view,null);

        if (!CollectionUtils.isEmpty(userHobbyList)){
            view.setHobbyList(userHobbyList);
        }

        return view;
    }

    private UserInfo structureUserInfo(UserInfoVO userInfoVO,String userId){
        UserInfo userInfo = new UserInfo();
        BeanCopier beanCopier = BeanCopier.create(UserInfoVO.class,UserInfo.class,false);
        beanCopier.copy(userInfoVO,userInfo,null);
        userInfo.setUserId(userId);
        return userInfo;
    }

}
