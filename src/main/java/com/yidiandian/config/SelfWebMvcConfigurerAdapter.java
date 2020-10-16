package com.yidiandian.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-16
 */

@Configuration
public class SelfWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    //图片存放根路径
    @Value("${file.rootPath}")
    private String ROOT_PATH;

    //图片存放根目录下的子目录
    @Value("${file.sonPath}")
    private String SON_PATH;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        String filePath = "file:" + ROOT_PATH;
        //指向外部目录
        registry.addResourceHandler("img//**").addResourceLocations(filePath);
        super.addResourceHandlers(registry);
    }

}
