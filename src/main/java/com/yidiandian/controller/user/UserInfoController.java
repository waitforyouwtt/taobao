package com.yidiandian.controller.user;

import com.yidiandian.entity.TravelLog;
import com.yidiandian.enums.EmailStatusEnum;
import com.yidiandian.service.*;
import com.yidiandian.support.Result;
import com.yidiandian.vo.ScenicSpotCommentVO;
import com.yidiandian.vo.ScenicSpotStarVO;
import com.yidiandian.vo.UserDynamicVO;
import com.yidiandian.vo.UserInfoVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-15
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    UserInfoDetailsService userInfoDetailsService;

    @Autowired
    TravelLogService travelLogService;

    @Autowired
    ScenicSpotStarService scenicSpotStarService;

    @Autowired
    ScenicSpotCommentService scenicSpotCommentService;

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
             vo.setEmailStatus(EmailStatusEnum.BIND.getCode());
             vo.setUserId(log.getUserId());
             userInfoDetailsService.updateUserDetails(vo);
        }
       return Result.success();
    }

    @ApiOperation(value = "用户修改自己的个人信息",notes = "=用户信息")
    @PostMapping("/updateUserInfo")
    public Result updateUserInfo(@RequestBody UserInfoVO vo){
      return userInfoService.updateUserInfo(vo);
    }

    @ApiOperation(value = "用户前往发布动态页面",notes = "=动态信息")
    @GetMapping("/toUserDynamic")
    public String toUserDynamic(){
        return "/html/userDynamic";
    }

    @ApiOperation(value = "用户发布个人动态信息",notes = "=用户信息")
    @PostMapping("/publishDynamic")
    @ResponseBody
    public Result publishDynamic(@ModelAttribute UserDynamicVO userDynamicVO){
        return userInfoService.publishDynamic(userDynamicVO);
    }

    @ApiOperation(value = "用户删除个人动态信息",notes = "=用户信息")
    @PostMapping("/deleteDynamic")
    @ResponseBody
    public Result deleteDynamicById(@RequestBody UserDynamicVO vo){
        return userInfoService.deleteDynamic(vo);
    }

    @ApiOperation(value = "用户对某条个人动态点赞",notes = "=用户信息")
    @PostMapping("/dynamicStar")
    @ResponseBody
    public Result dynamicStar(@RequestBody ScenicSpotStarVO vo){
        return scenicSpotStarService.dynamicStar(vo);
    }

    @ApiOperation(value = "用户对浏览的动态取消点赞",notes = "=用户信息")
    @PostMapping("/cancelDynamicStar")
    @ResponseBody
    public Result cancelDynamicStar(@RequestBody ScenicSpotStarVO vo){
        return scenicSpotStarService.cancelDynamicStar(vo);
    }

    @ApiOperation(value = "用户对浏览的动态评论",notes = "=用户信息")
    @PostMapping("/dynamicComment")
    @ResponseBody
    public Result dynamicComment(@RequestBody ScenicSpotCommentVO vo){
        return scenicSpotCommentService.dynamicComment(vo);
    }

    @ApiOperation(value = "用户对浏览的动态删除评论",notes = "=用户信息")
    @PostMapping("/cancelDynamicComment")
    @ResponseBody
    public Result cancelDynamicComment(@RequestBody ScenicSpotCommentVO vo){
        return scenicSpotCommentService.cancelDynamicComment(vo);
    }

}
