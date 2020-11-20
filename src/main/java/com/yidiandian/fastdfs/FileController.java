package com.yidiandian.fastdfs;

import com.yidiandian.support.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/11/15 16:28
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/upload")
    public Result uploadFile(MultipartFile file){
        try{
            //判断文件是否存在
            if (file == null){
                throw new RuntimeException("文件不存在");
            }
            //获取文件的完整名称
            String originalFilename = file.getOriginalFilename();
            if (StringUtils.isEmpty(originalFilename)){
                throw new RuntimeException("文件不存在");
            }

            //获取文件的扩展名称  abc.jpg   jpg
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

            //获取文件内容
            byte[] content = file.getBytes();

            //创建文件上传的封装实体类
            FastDFSFile fastDFSFile = new FastDFSFile(originalFilename,content,extName);
            fastDFSFile.setMd5( "abcdefghijklmnopqrstuvwxyz" );
            fastDFSFile.setAuthor( "yunlan" );

            //基于工具类进行文件上传,并接受返回参数  String[]
            String[] uploadResult = FastDFSClient.upload(fastDFSFile);

            //封装返回结果
            String url = FastDFSClient.getTrackerUrl()+uploadResult[0]+"/"+uploadResult[1];
            return new Result(true,200,"文件上传成功",url);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Result(false, 400,"文件上传失败");
    }

    @PostMapping("/download")
    public void download(@RequestBody Image image){
        InputStream input = FastDFSClient.downFile( image.getGroup(),image.getImage() );
        System.out.println("得到的六文件："+input);
    }
}
