package com.yidiandian.service.impl;

import cn.hutool.extra.template.TemplateException;
import com.yidiandian.service.EmailService;
import com.yidiandian.view.EmailView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 18:27
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    /**
     * 配置文件中我的qq邮箱
     */
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private Configuration configuration;


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
            mailSender.send(message);
        } catch (MessagingException e) {
           log.info("[邮件发送异常]：邮件多人多邮件带抄送人发送异常信息：{}",e.getMessage());
        }
    }

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        //创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人
        message.setFrom(from);
        //邮件接收人
        message.setTo(to);
        //邮件主题
        message.setSubject(subject);
        //邮件内容
        message.setText(content);
        //发送邮件
        mailSender.send(message);
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) {
        //获取MimeMessage对象
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {
            messageHelper = new MimeMessageHelper(message, true);
            //邮件发送人
            messageHelper.setFrom(from);
            //邮件接收人
            messageHelper.setTo(to);
            //邮件主题
            message.setSubject(subject);
            //邮件内容，html格式
            messageHelper.setText(content, true);
            //发送
            mailSender.send(message);
            //日志信息
            log.info("邮件已经发送...");
        } catch (MessagingException e) {
            log.error("发送邮件时发生异常！", e);
        }
    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            //FileSystemResource file = new FileSystemResource(new File(filePath));
            ClassPathResource resource = new ClassPathResource(filePath);
            FileSystemResource file = new FileSystemResource(resource.getFile());
            helper.addAttachment(Objects.requireNonNull(file.getFilename()), file);
            //可以同时添加多个附件,只需要在这里直接添加第2,第3...附件就行了.
            //helper.addAttachment(fileName2, file2);
            mailSender.send(message);
            //日志信息
            log.info("邮件已经发送...");
        } catch (MessagingException e) {
            log.error("发送邮件时发生异常！", e);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("发送邮件时发生异常！", e);
        }

    }

    @Override
    public void sendModelMail(String to, String subject, String fileName, Object model) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);

            Template template = configuration.getTemplate(fileName);
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            helper.setText(html, true);

            mailSender.send(mimeMessage);

            //日志信息
            log.info("邮件已经发送...");
        } catch (MessagingException e) {
            log.error("发送邮件时发生异常！", e);
        } catch (TemplateException e) {
            e.printStackTrace();
            log.error("发送邮件时发生异常！", e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (freemarker.template.TemplateException e) {
            e.printStackTrace();
        }
    }
}
