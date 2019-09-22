package com.yidiandian.service.impl;

import com.yidiandian.service.EmailService;
import com.yidiandian.view.EmailView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 18:27
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 邮件文字发送
     *
     * @param vo
     */
    @Override
    public void simpleSend(EmailView vo) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            //发送者
            helper.setFrom(vo.getEmailSender());
            String[] recipientsList = new String[vo.getEmailRecipients().size()];
            vo.getEmailRecipients().toArray(recipientsList);
            //接收者
            helper.setTo(recipientsList);
            String[] copyPersonList = new String[vo.getEmailCopyPersons().size()];
            vo.getEmailCopyPersons().toArray(copyPersonList);
            //抄送人，使用Cc还是Bcc大家根据具体场景自己选择
            helper.setCc(copyPersonList);
            //秘密抄送（发件人，收件人，抄送人都不会看到抄送给谁了）
            helper.setBcc(copyPersonList);
            //标题
            helper.setSubject(vo.getEmailSubject());
            helper.setText(vo.getEmailContent());
            mailSender.send(message);
        } catch (MessagingException e) {
            log.info("[邮件发送异常]：邮件文字发送异常信息：{}",e.getMessage());
        }
    }

    /**
     * 邮件多人多邮件带抄送人发送
     *
     * @param vo
     */
    @Override
    public void enclosureSend(EmailView vo) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(message,true);

            helper.setFrom(vo.getEmailSender());

            String[] recipientsList = new String[vo.getEmailRecipients().size()];
            vo.getEmailRecipients().toArray(recipientsList);
            helper.setTo(recipientsList);

            String[] copyPersonList = new String[vo.getEmailCopyPersons().size()];
            vo.getEmailCopyPersons().toArray(copyPersonList);
            //抄送人，使用Cc还是Bcc大家根据具体场景自己选择
            helper.setCc(copyPersonList);
            //秘密抄送（发件人，收件人，抄送人都不会看到抄送给谁了）
            helper.setBcc(copyPersonList);

            helper.setSubject(vo.getEmailSubject());
            helper.setText(vo.getEmailContent());

            List<String> emailFileList = new ArrayList<>();

            List<MultipartFile> files = vo.getFiles();
            if (!CollectionUtils.isEmpty(files)) {
                for (MultipartFile file : files) {
                    String fileName = file.getOriginalFilename();
                    emailFileList.add("D:\\photo\\"+fileName);
                }
            }
            log.info("文件集合：{}",emailFileList);

            if (!CollectionUtils.isEmpty( emailFileList )){
                FileSystemResource file=null;

                String[] fileList = new String[emailFileList.size()];
                emailFileList.toArray(fileList);

                for (int i = 0; i < fileList.length; i++) {
                    //添加附件
                    file=new FileSystemResource(fileList[i]);
                    helper.addAttachment(fileList[i].substring(fileList[i].lastIndexOf(File.separator)+1), file);
                }
            }


            //验证文件数据是否为空
            /*if(null != vo.getEmailFiles()){
                FileSystemResource file=null;

                String[] fileList = new String[vo.getEmailFiles().size()];
                vo.getEmailFiles().toArray(fileList);

                for (int i = 0; i < fileList.length; i++) {
                    //添加附件
                    file=new FileSystemResource(fileList[i]);
                    helper.addAttachment(fileList[i].substring(fileList[i].lastIndexOf(File.separator)+1), file);
                }
            }*/
            mailSender.send(message);
        } catch (MessagingException e) {
           log.info("[邮件发送异常]：邮件多人多邮件带抄送人发送异常信息：{}",e.getMessage());
        }
    }
}
