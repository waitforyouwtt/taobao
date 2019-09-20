package com.yidiandian.view;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 17:09
 * @Email: 15290810931@163.com
 */
@Data
public class EmailView implements Serializable {

    private Integer id;
    //发送者邮箱
    private String emailSender;
    //接受者邮箱
    private List<String> emailRecipients;
    //抄送人
    private List<String> emailCopyPersons;
    //邮件主题
    private String emailSubject;
    //邮件内容
    private String emailContent;
    //附件
    private List<String> emailFiles;

    private List<MultipartFile> files;

    private MultipartFile multipartFile;
}
