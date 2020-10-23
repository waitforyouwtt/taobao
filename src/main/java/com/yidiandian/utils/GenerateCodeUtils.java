package com.yidiandian.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-19
 */
@Slf4j
public class GenerateCodeUtils {

    /**
     * 根据省份code & 城市code 生成的平台景区景点唯一码
     * @param provinceCode
     * @param cityCode
     * @return
     */
    public static String generatePlatformUniqueCode(String provinceCode,String cityCode){
        String code = RandomStringUtils.random(5, "abcdefghijklmnopqrstuvwxyz0123456789");
        String uniqueCode = provinceCode.concat("_").concat(cityCode).concat("_").concat(code);
        log.info("生成的平台唯一码是：{}",uniqueCode);
        return uniqueCode;
    }

    /**
     * 生成邮件验证码
     * @return
     */
    public static String generateEmailCode(){
        String code = RandomStringUtils.random(5, "abcdefghijklmnopqrstuvwxyz0123456789");
        log.info("生成的邮件验证码是：{}",code);
        return code;
    }

}
