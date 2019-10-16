package cn.algerfan.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot15MailApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知-今晚搞事情");
        message.setText("今晚7:30搞事情");
        message.setTo("algerfan@163.com");
        message.setFrom("algerfan@qq.com");
        mailSender.send(message);
    }

    @Test
    public void test02() throws  Exception{
        //1、创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //邮件设置
        helper.setSubject("通知-今晚搞事情");
        helper.setText("<b style='color:red'>今晚7:30搞事情</b>",true);
        helper.setTo("algerfan@163.com");
        helper.setFrom("algerfan@qq.com");
        //上传文件
        helper.addAttachment("1.jpg",new File("C:\\Users\\algerfan\\Pictures\\开始图标\\1.bmp"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\algerfan\\Pictures\\开始图标\\11042111.bmp"));
        mailSender.send(mimeMessage);
    }

}

