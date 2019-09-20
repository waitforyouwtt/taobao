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
}
