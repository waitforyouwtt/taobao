package com.yidiandian.controller;

import cn.hutool.json.JSONObject;
import com.yidiandian.vo.ScenicSpotInfoVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-16
 */
@Controller
public class FileController {

    //图片存放根路径
    @Value("${file.rootPath}")
    private String ROOT_PATH;

    //图片存放根目录下的子目录
    @Value("${file.sonPath}")
    private String SON_PATH;

    @PostMapping(value="/upload")
    @ResponseBody
    public JSONObject upload(@RequestParam("file") MultipartFile[] file,Model model) throws IOException {
        JSONObject jsonObject = new JSONObject();

        System.out.println("数组的长度"+file.length);
        for (int i = 0; i < file.length; i++) {
            String originalFilename = file[i].getOriginalFilename();
            InputStream inputStream = file[i].getInputStream();
           // OSSUtil.uploadImageToOSS(originalFilename, inputStream);
        }
        //uploadFile(file.getBytes(),filePath,fileName);
        jsonObject.put("success",1);

        return jsonObject;
    }

    /*@PostMapping(value="/upload")
    @ResponseBody
    public JSONObject upload(@RequestParam("file") MultipartFile file, Model model){
        JSONObject jsonObject = new JSONObject();
        //文件名称1970到现在的毫秒数文件名称
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();
        //文件绝对路径
        String filePath = "/Users/farben/Documents/IdeaProjects/ydd/taobao/src/main/resources/static/img/";
        //判断是否上传
        if (jsonObject.isEmpty()){
            //失败输出0
            jsonObject.put("success","0");
            jsonObject.put("fileName","");
        }
        try {
            //调用定义的方法，进行操作
            uploadFile(file.getBytes(),filePath,fileName);
            jsonObject.put("success",1);
            jsonObject.put("fileName",fileName);
            jsonObject.put("xfileName",ROOT_PATH+"/"+fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("xfileName",filePath+fileName);
        return jsonObject;
    }*/

    public static void uploadFile(byte[] file,String filePath,String fileName)throws Exception{
        //给出路径进行操作
        File targetFile = new File(filePath);
        //判断是否存在
        if (targetFile.exists()){
            //不存在，自动创建
            targetFile.mkdirs();
        }
        //字符输出流，向文件写入
        //定位文件
        FileOutputStream fileOutputStream = new FileOutputStream(filePath+"/"+fileName);
        fileOutputStream.write(file);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
