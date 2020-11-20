package com.yidiandian.fastdfs;

import lombok.Data;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/11/15 16:20
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class FastDFSFile {

    //文件名字
    private String name;
    //文件内容
    private byte[] content;
    //文件扩展名
    private String ext;
    // 文件MD5摘要值
    private String md5;
    //文件创建作者
    private String author;

    public FastDFSFile(String name, byte[] content, String ext, String height, String width, String author) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;
        this.author = author;
    }

    public FastDFSFile(String name, byte[] content, String ext) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;
    }
}
