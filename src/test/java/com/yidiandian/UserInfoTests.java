package com.yidiandian;

import com.yidiandian.entity.UserInfo;
import com.yidiandian.service.UserInfoService;
import com.yidiandian.vo.ListUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public static String addZeroForNum(String str, int strLength) {
		int strLen = str.length();
		if (strLen < strLength) {
			while (strLen < strLength) {
				StringBuffer sb = new StringBuffer();
				sb.append("0").append(str);// 左补0
				// sb.append(str).append("0");//右补0
				str = sb.toString();
				strLen = str.length();
			}
		}

		return str;
	}

	private String autoGenericCode(String code,int length) {
		String result = "";
		// 保留code的位数
		result = String.format("%0" + length + "d", Integer.parseInt(code) + 1);

		return result;
	}

	private static void getStr1(String Str) {
		//切分
		String regex = "/";
		String[] strings = Str.split(regex);
		//输出结果
		System.out.println(strings[2]);
	}

	private static void getStr2(String Str) {
		String newStr = Str.replace("http://", "");
		String string = newStr.substring(0, newStr.indexOf("/"));
		System.out.println(string);
	}


	private static String getStr3(String Str) {
		Pattern pattern = Pattern.compile("[^http://]*?.cn");
		Matcher matcher = pattern.matcher(Str);
		while(matcher.find()){
			String group = matcher.group();
			System.out.println(group);
		}
		return null;
	}


}
