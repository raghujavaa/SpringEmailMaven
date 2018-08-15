package com.app.service.impl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.app.service.IMailService;

@Service("mailService")
public class MailServiceImpl implements IMailService {

	@Autowired
	private JavaMailSenderImpl mailSender;

	public boolean sendEmail(String to, String subject, String text,
			FileSystemResource file) {
		boolean isSuccess = false;
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,
					file != null ? true : false);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setFrom("raghubr57@gmail.com");
			helper.setText(text);
			if (file != null)
				helper.addAttachment(file.getFilename(), file);
			mailSender.send(message);
			isSuccess = true;
		} catch (Exception e) {
			isSuccess = false;
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean sendEmail(String to, String subject, String text) {
		return this.sendEmail(to, subject, text, null);
	}// sendEmail() finally ok

}// class
