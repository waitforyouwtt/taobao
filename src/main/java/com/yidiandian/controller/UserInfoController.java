package com.yidiandian.controller;

import com.yidiandian.service.UserInfoService;
import com.yidiandian.vo.UserInfoVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-15
 */
@RestController
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @ApiOperation(value = "保存用户信息",notes = "=保存用户信息")
    @PostMapping("/saveUserInfo")
    public String saveUserInfo(@RequestBody UserInfoVO vo){
        userInfoService.insertUserInfo(vo);
        return "success";
    }
}
