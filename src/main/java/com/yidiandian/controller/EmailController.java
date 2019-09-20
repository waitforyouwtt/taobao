package com.yidiandian.controller;

import com.yidiandian.service.EmailService;
import com.yidiandian.view.EmailView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 17:04
 * @Email: 15290810931@163.com
 */
@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    //发送文本消息，不带附件
    @PostMapping("/simple-send")
    public String send(@RequestBody EmailView vo) {
        emailService.simpleSend(vo);
        return "true";
    }

    //发送文本消息，不带附件
    @PostMapping("/enclosure-send")
    public String enclosureSend(@ModelAttribute EmailView vo){
        List<String> fileArray = Arrays.asList("D:\\photo\\cat.jpg","D:\\photo\\pretty boy.jpg","D:\\photo\\self.jpg" );
        vo.setEmailFiles(fileArray);
        emailService.enclosureSend(vo);
        return "true";
    }
}
