package com.yidiandian.controller;

import com.yidiandian.service.EmailService;
import com.yidiandian.view.EmailView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 17:04
 * @Email: 15290810931@163.com
 */
@RestController
@Slf4j
public class EmailController {

    @Autowired
    EmailService emailService;

    //发送文本消息，不带附件
    @PostMapping("/simple-send")
    public String send(@RequestBody EmailView vo) {
        emailService.simpleSend(vo);
        return "true";
    }

    //发送文本消息，带附件
    @PostMapping("/enclosure-send")
    public String enclosureSend(@ModelAttribute EmailView vo,HttpServletRequest request){
        emailService.enclosureSend(vo);
        return "true";
    }
}
