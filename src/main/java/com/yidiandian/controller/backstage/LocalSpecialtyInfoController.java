package com.yidiandian.controller.backstage;

import com.yidiandian.service.LocalSpecialtyInfoService;
import com.yidiandian.support.Result;
import com.yidiandian.vo.LocalSpecialtyInfoVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-23
 */
@Controller
public class LocalSpecialtyInfoController {

    @Autowired
    LocalSpecialtyInfoService localSpecialtyInfoService;

    @ApiOperation(value = "后台前往特产发布页面",notes = "=动态信息")
    @GetMapping("/toPublishLocalSpecialty")
    public String toPublishLocalSpecialty(){
        return "/html/backstagePublishLocalSpecialty";
    }

    @ApiOperation(value = "后台创建特产商品",notes = "=动态信息")
    @PostMapping("/backstagePublishLocalSpecialty")
    @ResponseBody
    public Result backstagePublishLocalSpecialty(@ModelAttribute LocalSpecialtyInfoVO vo){
        return localSpecialtyInfoService.saveLocalSpecialtyInfo(vo);
    }


}
