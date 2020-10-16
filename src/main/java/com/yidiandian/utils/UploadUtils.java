package com.yidiandian.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-16
 */
public class UploadUtils {

    //图片存放根路径
    private static String ROOT_PATH = "/Users/farben/Documents/IdeaProjects/ydd/taobao/src/main/resources/static/img/";

    private static String SON_PATH  = "/img/";

    public static String upload(MultipartFile file){
        //防止上传空文件导致奔溃
        if (file.isEmpty()) {
            throw new NullPointerException("文件为空");
        }
        // 设置文件上传后的路径
        String filePath = ROOT_PATH;
        // 获取文件名后缀名
        String suffix = file.getOriginalFilename();
        String prefix = suffix.substring(suffix.lastIndexOf(".")+1);

        //为防止文件重名被覆盖，文件名取名为：当前日期 + 1-1000内随机数
        Random random = new Random();
        Integer randomFileName = random.nextInt(1000);
        String fileName = System.currentTimeMillis() + randomFileName +"." +  prefix;

        //创建文件路径
        File dest = new File(filePath + fileName);
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            //假如文件不存在即重新创建新的文件已防止异常发生
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //保存t_upload_file表中的地址
        String filePathNew = SON_PATH + fileName;
        /*String profilePhoto = saveUploadFile(filePathNew);
        return profilePhoto;*/
        return filePathNew;
    }

}
