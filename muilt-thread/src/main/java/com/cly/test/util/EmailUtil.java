/*
package com.cly.test.util;

import com.ltit.trash.common.common.api.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Arrays;


@Slf4j
@Service
public class EmailUtil {
    @Autowired
    private JavaMailSender javaMailSender;

    //注入配置文件中配置的信息——>from
    @Value("${spring.mail.username}")
    private String from;
    */
/**
     * 附件根目录
     *//*

    @Value("${jeecg.path.emailFileDir}")
    private String emailFileDir;


    private static final String ENCODING_CODE="UTF-8";



    */
/**
     * 普通
     * @param to
     * @param subject
     * @param content
     *//*

    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        //发件人
        message.setFrom(from);
        //收件人
        message.setTo(to);
        //邮件主题
        message.setSubject(subject);
        //邮件内容
        message.setText(content);
        //发送邮件
        javaMailSender.send(message);
    }

    */
/**
     * 发送html
     * @param to
     * @param subject
     * @param content
     *//*

    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {
            messageHelper = new MimeMessageHelper(message,true,"UTF-8");
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            message.setSubject(subject);
            messageHelper.setText(content,true);
            javaMailSender.send(message);
            log.info("邮件已经发送！");
        } catch (MessagingException e) {
            log.error("发送邮件时发生异常："+e);
        }
    }

    */
/**
     * 发送附件
     * @param to
     * @param subject
     * @param content
     * @param filePaths
     *//*

    public Result<Object> sendAttachmentsMail(String to, String subject, String content, String filePaths) {
        Result<Object> result=new Result<>();
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {
            messageHelper = new MimeMessageHelper(message,true,ENCODING_CODE);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content,true);
            if(StringUtils.isBlank(filePaths)){
                result.setSuccess(false);
                result.setMessage("附件未传");
                return result;
            }
            //携带附件
            for(String filePath:Arrays.asList(filePaths.split(","))){
                filePath=emailFileDir+filePath;
                FileSystemResource file = new FileSystemResource(filePath);
                String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
                messageHelper.addAttachment(fileName,file);
            }
            javaMailSender.send(message);
            result.setSuccess(true);
            result.setMessage("邮件发送成功");
        } catch (MessagingException e) {
            result.setSuccess(false);
            result.setMessage("邮件发送失败");
        }
        return result;
    }

}
*/
