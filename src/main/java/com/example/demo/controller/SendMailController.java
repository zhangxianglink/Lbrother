package com.example.demo.controller;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class SendMailController {
	
	@Value("${spring.mail.username}")
	private String from;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@RequestMapping("/txt")
	public String sendTxtmail(String to,String subject,String context){
		try {
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setSubject(subject);
			mail.setFrom(from);
			mail.setTo(to);
			mail.setText(context);
			javaMailSender.send(mail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "I am so Sorry Baby! send mail error";
		}
		return "send successful!";
		
	}
	
	/**
	 * 发送网页邮件
	 * @throws MessagingException 
	 */
	public void sendHtmlMail(String to,String subject,String context) throws MessagingException{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setFrom(from);
		helper.setText(context, true);
		javaMailSender.send(mimeMessage);
	}
	
	/**
	 * 发送附件邮件
	 * @throws MessagingException 
	 */
	public void sendAttachmentMail(String to,String subject,String context,String filePath) throws MessagingException{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setFrom(from);
		helper.setText(context, true);
		//单独添加一个附件，多个的话数组的形式
		FileSystemResource resource = new FileSystemResource(new File(filePath));
		String filename = resource.getFilename();
		helper.addAttachment(filename, resource);
		javaMailSender.send(mimeMessage);
	}
	
	/**
	 * 发送图片邮件
	 */
	public void sendInlineMail(String to,String subject,String context,String Path,String id) throws MessagingException{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setFrom(from);
		helper.setText(context, true);
		//单独添加一个附件，多个的话数组的形式
		FileSystemResource resource = new FileSystemResource(new File(Path));
		helper.addInline(id, resource);
		javaMailSender.send(mimeMessage);
	}
}
