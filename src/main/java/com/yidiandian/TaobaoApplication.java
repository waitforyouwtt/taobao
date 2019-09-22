package com.yidiandian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class TaobaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaobaoApplication.class, args);
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//单个文件最大  //KB,MB
		factory.setMaxFileSize("50240KB");
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("502400KB");
		return factory.createMultipartConfig();
	}

}
