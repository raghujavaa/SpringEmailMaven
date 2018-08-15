package com.app.service;

import java.nio.file.FileSystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@ComponentScan({ "com.app" })
public interface IMailService {

	public boolean sendEmail(String to, String subject, String text);

	public boolean sendEmail(String to, String subject, String text,
			FileSystemResource file);

}// interface
