package com.yidiandian.controller;

import com.yidiandian.service.ScenicSpotInfoService;
import com.yidiandian.vo.ScenicSpotInfoVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-15
 */
@RestController
@RequestMapping("/ScenicSpotInfo")
public class ScenicSpotInfoController {

    @Autowired
    ScenicSpotInfoService scenicSpotInfoService;

    @ApiOperation(value = "用户发表动态",notes = "=动态信息")
    @PostMapping("/publishMessage")
    public String publishMessage(@RequestBody ScenicSpotInfoVO vo){
        int i = scenicSpotInfoService.publishMessage(vo);
        return "success";
    }
}
