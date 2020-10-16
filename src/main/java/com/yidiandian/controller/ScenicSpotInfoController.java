package com.yidiandian.controller;

import com.yidiandian.service.ScenicSpotInfoService;
import com.yidiandian.view.ScenicSpotInfoView;
import com.yidiandian.vo.QueryScenicSpotVO;
import com.yidiandian.vo.ScenicSpotInfoVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-15
 */
@Controller
@RequestMapping("/ScenicSpotInfo")
public class ScenicSpotInfoController {

    @Autowired
    ScenicSpotInfoService scenicSpotInfoService;

    @ApiOperation(value = "用户前往发表动态页面",notes = "=动态信息")
    @GetMapping("/toPublishMessage")
    public String topublishMessage(){
        return "/toPublishMessage";
    }

    @ApiOperation(value = "用户发表动态",notes = "=动态信息")
    @PostMapping("/publishMessage")
    public String publishMessage(@ModelAttribute  ScenicSpotInfoVO vo){
         int i = scenicSpotInfoService.publishMessage(vo);
        return "success";
    }

    @ApiOperation(value = "查看用户发表的动态",notes = "=动态信息")
    @PostMapping("/findSpotInfo")
    public String findSpotInfo(@RequestBody QueryScenicSpotVO spotVO){
        List<ScenicSpotInfoView> viewList = scenicSpotInfoService.findSpotInfo(spotVO);
        return "success";
    }
}
