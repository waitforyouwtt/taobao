package com.yidiandian.controller;

import com.yidiandian.service.UserInfoService;
import com.yidiandian.view.UserInfoView;
import com.yidiandian.vo.UserInfoVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-15
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @ApiOperation(value = "保存用户信息",notes = "=用户信息")
    @PostMapping("/saveUserInfo")
    public String saveUserInfo(@RequestBody UserInfoVO vo){
        userInfoService.insertUserInfo(vo);
        return "success";
    }

    @ApiOperation(value = "根据token获取用户信息",notes = "=用户信息")
    @PostMapping("/findUserInfo")
    public String findUserInfo(@RequestParam String userId){
        String token = "1";
        UserInfoView view = userInfoService.findUserInfo(userId);
        return "success";
    }
}
