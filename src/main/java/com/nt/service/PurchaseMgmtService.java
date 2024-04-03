package com.nt.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service("purchase")
public class PurchaseMgmtService implements IpurchaseOrder{
   @Autowired	
   private JavaMailSender mailsender;
   @Value("${spring.mail.username}")
	private String fromMail;
   @Override
	public String purchase(String[] items, String[] emailas) throws MessagingException {
		// TODO Auto-generated method stub
	   String msg=Arrays.toString(items);
	   String status=sendMail(msg,emailas);
		return msg+" "+status;
	}
private String sendMail(String msg, String[] emailas) throws MessagingException {
	// TODO Auto-generated method stub
	MimeMessage message=mailsender.createMimeMessage();
	MimeMessageHelper helper=new MimeMessageHelper(message,true);
	helper.setFrom(fromMail);
	helper.setCc(emailas);
	helper.setSubject("open and see it");
	helper.setSentDate(new Date());
	helper.setText(msg);
	helper.addAttachment("logo.png",new ClassPathResource("logo.png"));
	mailsender.send(message);
	return "mail sent";
}

}
