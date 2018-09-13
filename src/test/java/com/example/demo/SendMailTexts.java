package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.example.demo.controller.SendMailController;
import com.google.gson.Gson;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SendMailTexts {
	
	@Autowired
	private SendMailController controller;
	
	@Autowired
	private TemplateEngine template;
	
	@Test
	public void TxtMail(){
		controller.sendTxtmail("1059976480@qq.com", "来自163的问候", "你好，这是一份文本邮件");
	}
	
	@Test
	public void HtmlMail() throws MessagingException{
		String context =  "<html>\n"
	                              +"<body>\n"
				                       +"<h1>网页邮件</h1>"
				                  +"</body>\n" 
	                      +"</html>";
		controller.sendHtmlMail("1059976480@qq.com", "来自163的问候",context );
	}
	
	@Test
	public void AttachmentMail() throws MessagingException, IOException{
		String filePath = "E:/ww.txt";
		String context = "本地磁盘文件";
		controller.sendAttachmentMail("1059976480@qq.com", "来自163的问候",  context ,filePath);
	}
	
	@Test
	public void InLineMail() throws MessagingException, IOException{
		String imgPath = "E:/a.jpg";
		String id = "photo_a";
		String context = "<html><body>图片a:<img src=\'cid:"+id+"\'></img></body></html>";
		controller.sendInlineMail("1059976480@qq.com", "来自163的问候", context, imgPath, id);
	}
	
	@Test
	public void templateMail() throws MessagingException{
		Context context = new Context();
		context.setVariable("id", "007");
		String process = template.process("mailTemplate", context);
		controller.sendHtmlMail("1059976480@qq.com", "来自163的问候", process);
		
	}

	@Test
	public void FileTest() throws IOException {
		//读取静态资源
		ClassPathResource classPathResource = new ClassPathResource("/static/hi.txt");
		File file = classPathResource.getFile();
		String path = file.getPath();
		
		String path2 = ClassUtils.getDefaultClassLoader().getResource("").getPath();
		System.out.println("获取spring项目的绝对路径"+path2);
	}
	
	@Test
	public void countryTest() throws IOException{
		//读取静态资源
		ClassPathResource classPathResource = new ClassPathResource("/static/hi.txt");
		File file = classPathResource.getFile();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		Gson gson = new Gson();
		ArrayList<Object> arrayList = new ArrayList<>();
		while((line =br.readLine()) != null){
			try {
				HashMap<String, Object> map = new HashMap<>();
				String[] split = line.split(" ");
				map.put("EN", split[2]);
				map.put("CN", split[3]);
				map.put("NUM", split[4]);
				String json = gson.toJson(map);
				arrayList.add(json);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
		br.close();
		System.out.println(arrayList.size());
		System.out.println(arrayList);
	}
}
