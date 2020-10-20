package com.yidiandian.controller.backstage;

import com.yidiandian.service.ScenicSpotInfoService;
import com.yidiandian.support.Result;
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
@RequestMapping("/backstage")
public class ScenicSpotInfoController {

    @Autowired
    ScenicSpotInfoService scenicSpotInfoService;

    @ApiOperation(value = "后台发布景点景区前往动态页面",notes = "=动态信息")
    @GetMapping("/backstagePublishMessage")
    public String topublishMessage(){
        return "/html/backstagePublishMessage";
    }

    @ApiOperation(value = "后台发布景点景区动态",notes = "=动态信息")
    @PostMapping("/publishMessage")
    @ResponseBody
    public Result publishMessage(@ModelAttribute  ScenicSpotInfoVO vo){
        return scenicSpotInfoService.publishMessage(vo);
    }

    @ApiOperation(value = "查看用户发表的动态",notes = "=动态信息")
    @PostMapping("/findSpotInfo")
    public String findSpotInfo(@RequestBody QueryScenicSpotVO spotVO){
        List<ScenicSpotInfoView> viewList = scenicSpotInfoService.findSpotInfo(spotVO);
        return "success";
    }
}
