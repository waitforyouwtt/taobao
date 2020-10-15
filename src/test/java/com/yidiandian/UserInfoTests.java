package com.yidiandian;


import com.yidiandian.entity.UserInfo;
import com.yidiandian.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserInfoTests extends TaobaoApplicationTests{

	@Autowired
	UserInfoService userInfoService;

	@Test
	public void findUserInfoByUserName(){
		UserInfo 云澜 = userInfoService.findUserInfoByUserName("云澜");
		log.info("通过用户名查询用户信息:{}",云澜);
	}


}
