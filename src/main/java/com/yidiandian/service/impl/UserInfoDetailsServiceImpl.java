package com.yidiandian.service.impl;

import com.yidiandian.aspect.LogAnnotation;
import com.yidiandian.dao.UserInfoDetailsDao;
import com.yidiandian.entity.UserInfoDetails;
import com.yidiandian.enums.EmailStatusEnum;
import com.yidiandian.service.EmailService;
import com.yidiandian.service.UserInfoDetailsService;
import com.yidiandian.support.Result;
import com.yidiandian.utils.GenerateCodeUtils;
import com.yidiandian.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    EmailService emailService;

    @Override
    @LogAnnotation
    public Result saveUserDetails(UserInfoVO userInfoVO, String userId) {
        int insert = userInfoDetailsDao.insert(structureUserInfoDetails(userInfoVO, userId));
        sendMail(userInfoVO);
        return insert > 0 ? Result.success() : Result.error();
    }

    private void sendMail(UserInfoVO userInfoVO){
        if (StringUtils.isBlank(userInfoVO.getEmail())){
            return;
        }else{
            //主题
            String subject = "来自一一【驴行天下】网站的激活邮件";
            //user/checkCode?code=code(激活码)是我们点击邮件链接之后根据激活码查询用户，如果存在说明一致，将用户状态修改为“1”激活
            //上面的激活码发送到用户注册邮箱
            //注意:此处的链接地址,是项目内部地址,如果我们没有正式的服务器地址,暂时无法从qq邮箱中跳转到我们自己项目的激活页面
            String context = "<a href=\"http://192.168.17.183:8080/user/checkCode?code="+userInfoVO.getVerifyCode()+"\">激活请点击:"+userInfoVO.getVerifyCode()+"</a>";
            //发送激活邮件
            emailService.sendHtmlMail (userInfoVO.getEmail(),subject,context);
        }
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

    @Override
    public int updateUserDetails(UserInfoVO userInfoVO) {
        return userInfoDetailsDao.update(structureUpdate(userInfoVO));
    }

    private UserInfoDetails structureUpdate(UserInfoVO vo){
        UserInfoDetails info = new UserInfoDetails();
        BeanCopier beanCopier = BeanCopier.create(UserInfoVO.class,UserInfoDetails.class,false );
        beanCopier.copy(vo,info,null);
        return info;
    }


    private UserInfoDetails structureUserInfoDetails(UserInfoVO userInfoVO,String userId){
        UserInfoDetails userInfoDetails = new UserInfoDetails();
        BeanCopier beanCopier = BeanCopier.create(UserInfoVO.class,UserInfoDetails.class,false);
        beanCopier.copy(userInfoVO,userInfoDetails,null);
        userInfoDetails.setUserId(userId);
        userInfoDetails.setEmailStatus(EmailStatusEnum.NO_BIND.getCode());
        return userInfoDetails;
    }
}
