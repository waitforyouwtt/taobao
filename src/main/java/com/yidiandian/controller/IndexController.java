package com.yidiandian.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/5 22:02
 * @Email: 15290810931@163.com
 */
@Controller
@Slf4j
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "/index";
    }

    @GetMapping("/email")
    public String email(){return "/email";}
}
