package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.app.config.AppConfig;
import com.app.service.IMailService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				AppConfig.class);

		IMailService service = ctx.getBean("mailService", IMailService.class);
		FileSystemResource file = new FileSystemResource(
				"C:/Users/Public/Pictures/Koala.jpg");
		boolean sent = service.sendEmail("raghunadh28@gmail.com",
				"Test Subject", "Test Body...", file);

		if (sent)
			System.out.println("Success");

		else
			System.out.println("Fail");

	}// main()
}// Test class
