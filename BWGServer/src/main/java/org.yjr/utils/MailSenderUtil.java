package org.yjr.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.yjr.utils.entity.MailDO;

import javax.mail.internet.MimeMessage;
import java.util.List;

@Component
public class MailSenderUtil {

    private Logger logger = LoggerFactory.getLogger(MailSenderUtil.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${mail.from}")
    private String from;

    public ReturnResult send(List<String> to, MailDO mailDO){
        ReturnResult returnResult = new ReturnResult();
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            BeanUtils.copyProperties(mailDO,simpleMailMessage);
            simpleMailMessage.setFrom(from);
//            System.out.println("*********from***********:"+from);
            if(to.size()>0){
                simpleMailMessage.setTo(to.toArray(new String[to.size()]));
                javaMailSender.send(simpleMailMessage);
                returnResult.setCode("1");
                returnResult.setMsg("发件成功");
            }else{
                returnResult.setCode("0");
                returnResult.setMsg("没有收件人");
            }
        }catch (Exception e){
            returnResult.setCode("0");
            returnResult.setMsg(e.getMessage());
        }finally {
            return returnResult;
        }
    }

    public ReturnResult sendTemplateMail(List<String> to, MailDO mailDO){
        ReturnResult returnResult = new ReturnResult();
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true,"utf-8");
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to.toArray(new String[to.size()]));
            mimeMessageHelper.setSubject(mailDO.getSubject());
            //模板参数
            Context context = new Context();
            context.setVariables(mailDO.getMap());
            //模板转字符串
            String process = templateEngine.process(mailDO.getMailPath(),context);
            //html模式
            mimeMessageHelper.setText(process,true);
            //邮件发送方法
            javaMailSender.send(mimeMessage);
            //成功信息
            returnResult.setCode("1");
            returnResult.setMsg("发件成功");
        }catch (Exception e){
            //异常信息
            returnResult.setCode("0");
            returnResult.setMsg(e.getMessage());
        }finally {
            //无论是否成功 返回结果信息
            return returnResult;
        }
    }
}
