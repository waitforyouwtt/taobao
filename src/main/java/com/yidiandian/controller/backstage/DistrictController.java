package com.yidiandian.controller.backstage;

import com.yidiandian.service.DistrictService;
import com.yidiandian.support.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-16
 */
@Controller
public class DistrictController {

    @Autowired
    DistrictService districtService;

    @PostMapping("/findBbsAreaByUPid")
    @ResponseBody
    public Result findBbsAreaByUPid(@RequestParam("upid") int upid){
        return Result.success(districtService.findBbsAreaByUPid(upid));
    }

    
}
