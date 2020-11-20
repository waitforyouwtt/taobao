package com.yidiandian.controller.backstage;

import com.yidiandian.page.PageRequest;
import com.yidiandian.service.ScenicSpotInfoService;
import com.yidiandian.support.Result;
import com.yidiandian.view.ScenicSpotInfoView;
import com.yidiandian.view.ScenicSpotView;
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

    @ApiOperation(value = "后台景点景区查询页面",notes = "=动态信息")
    @GetMapping("/toScenliSpotList")
    public String toScenliSpotList(){
        return "/html/scenliSpotList";
    }

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

    @ApiOperation(value = "查询景点景区且根据省份城市分组",notes = "=动态信息")
    @PostMapping("/queryScenicSpotGroup")
    @ResponseBody
    public Result queryScenicSpot(@RequestBody(required = false) QueryScenicSpotVO vo){
        List<ScenicSpotView> data = (List<ScenicSpotView>) scenicSpotInfoService.queryScenicSpotGroup(vo).getData();
        return Result.success(data);
    }

    @ApiOperation(value = "查看用户发表的动态",notes = "=动态信息")
    @PostMapping("/findSpotInfo")
    public String findSpotInfo(@RequestBody QueryScenicSpotVO spotVO){
        List<ScenicSpotInfoView> viewList = scenicSpotInfoService.findSpotInfo(spotVO);
        return "success";
    }

    @ApiOperation(value = "用户查询动态且分页", notes = "动态信息")
    @PostMapping("/findDynamicPage")
    @ResponseBody
    public Result findDynamicPage(@RequestBody PageRequest pageRequest){
        return scenicSpotInfoService.findSpotInfoPage(pageRequest);
    }

    @ApiOperation(value = "查询image动态且分页", notes = "动态信息")
    @GetMapping("/findImagePage")
    @ResponseBody
    public Result findImagePage(PageRequest pageRequest){
        return scenicSpotInfoService.findSpotInfoPage(pageRequest);
    }
}
