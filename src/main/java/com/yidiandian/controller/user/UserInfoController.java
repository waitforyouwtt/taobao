package com.yidiandian.controller.user;

import com.yidiandian.entity.TravelLog;
import com.yidiandian.entity.UserInfoDetails;
import com.yidiandian.service.TravelLogService;
import com.yidiandian.service.UserInfoDetailsService;
import com.yidiandian.service.UserInfoService;
import com.yidiandian.support.Result;
import com.yidiandian.vo.UserInfoVO;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.units.qual.A;
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

    @Autowired
    UserInfoDetailsService userInfoDetailsService;

    @Autowired
    TravelLogService travelLogService;

    @ApiOperation(value = "注册新用户",notes = "=用户信息")
    @PostMapping("/saveUserInfo")
    public Result saveUserInfo(@RequestBody UserInfoVO vo){
        return userInfoService.insertUserInfo(vo);
    }

    @ApiOperation(value = "根据token获取用户信息",notes = "=用户信息")
    @PostMapping("/findUserInfo")
    public Result findUserInfo(@RequestParam("token") String token){
        return userInfoService.findUserInfo(token);
    }


    @ApiOperation(value = "用户打开自己的邮箱点击激活链接，激活邮箱",notes = "=用户信息")
    @GetMapping("/checkCode")
    public Result checkCode(@RequestParam("code") String code){
        TravelLog log = travelLogService.findLogByCode(code);
        if (log != null){
             UserInfoVO vo = new UserInfoVO();
             vo.setEmailStatus(1);
             vo.setUserId(log.getUserId());
             userInfoDetailsService.updateUserDetails(vo);
        }
       return Result.success();
    }
}
