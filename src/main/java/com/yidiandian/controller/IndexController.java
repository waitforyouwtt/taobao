package com.yidiandian.controller;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.TimeUnit;

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

    /**
     * 定义每秒钟发放2个令牌
     */
    RateLimiter limiter = RateLimiter.create(2.0);

    /**
     * 1.非阻塞式限流
     * 从代码中我们看到，我们的令牌桶中每秒钟只能产生2个令牌，可以设想当请求的令牌数量小于等于2个时，接口可以正常响应成功
     * http://localhost:8080/tryAcquire?count=1
     * http://localhost:8080/tryAcquire?count=2
     * http://localhost:8080/tryAcquire?count=4
     * @param count
     * @return
     */
    @GetMapping("/tryAcquire")
    public String tryAcquire(Integer count){
        if(limiter.tryAcquire(count)){
            log.info("get success,curr rate is:{}",limiter.getRate());
            return "success";
        }else {
            log.info("get fail,curr rate is:{}",limiter.getRate());
            return "fail";
        }
    }

    /**
     * 2、限定时间的阻塞式限流
     *    在获取令牌的时候设定了可以等待的时间，如果未超出这个时间，请求会被hang一会儿，直到获得令牌，超出这个时间，则快速响应客户端
     *    http://localhost:8080/tryAcquireHasTimeOut?count=1&timeout=0
     *    http://localhost:8080/tryAcquireHasTimeOut?count=2&timeout=5
     *    假如请求的令牌数是2个，设置的超时时间是5秒，第一个请求过来时，由于初始桶中的令牌数有2个，可以说在5秒之内无需等待就可以立即返回结果了，
     *    但是如果更多同样的请求过来的话，桶中的数量不够了，但是能够容忍的最大等待时间是5秒，因此只要在5秒内可以拿到令牌也可以
     */
    @GetMapping("/tryAcquireHasTimeOut")
    public String tryAcquireHasTimeOut(Integer count,Integer timeout){
        if(limiter.tryAcquire(count,timeout, TimeUnit.SECONDS)){
            log.info("get success,curr rate is:{}",limiter.getRate());
            return "success";
        }else {
            log.info("get fail,curr rate is:{}",limiter.getRate());
            return "fail";
        }
    }

    /**
     * 阻塞式限流：请求如果拿不到令牌的话就会阻塞在那儿，直到拿到令牌为止
     */
    @GetMapping("/acquireSync")
    public String acquireSync(Integer count){
        limiter.acquire(count);
        log.info("get success,curr rate is:{}",limiter.getRate());
        return "success";
    }


}
