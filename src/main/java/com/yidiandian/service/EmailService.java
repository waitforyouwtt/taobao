package com.yidiandian.service;

import com.yidiandian.view.EmailView;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 18:25
 * @Email: 15290810931@163.com
 */
public interface EmailService {

    /**
     * 邮件文字发送
     */
    void simpleSend(EmailView vo);

    /**
     * 邮件多人多邮件带抄送人发送
     */
    void enclosureSend(EmailView vo);

    //<------------------------------------------------->

    /**
     * 发送文本邮件
     *
     * @param to      收件人
     * @param subject 主题
     * @param content 内容
     */
    void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送HTML邮件
     *
     * @param to      收件人
     * @param subject 主题
     * @param content 内容
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     *
     * @param to       收件人
     * @param subject  主题
     * @param content  内容
     * @param filePath 附件
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath);

    /**
     * 发送模板邮件
     * @param to 收件人
     * @param subject 主题
     * @param fileName 邮件模板文件名称
     * @param model 邮件数据载体
     */
    void sendModelMail(String to, String subject, String fileName, Object model);

}
