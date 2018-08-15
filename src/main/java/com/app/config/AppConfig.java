package com.app.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan({ "com.app" })
public class AppConfig {

	@Bean
	public JavaMailSenderImpl mail() {
		JavaMailSenderImpl mail = new JavaMailSenderImpl();
		mail.setHost("smtp.gmail.com");
		mail.setPort(587);
		mail.setUsername("raghubr57@gmail.com");
		mail.setPassword("Raghu_111");
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		mail.setJavaMailProperties(props);
		return mail;
	}
}
/*
 * config.xml <bean name="mailSender"
 * class="org.springframework.mail.javamail.JavaMailSenderImpl"> <property
 * name="host" value="smtp.gmail.com" /> <property name="port" value="587" />
 * <property name="username" value="javaraghu2018@gmail.com" /> <property
 * name="password" value="2018java2018raghu" /> <property
 * name="javaMailProperties"> <props> <prop key="mail.smtp.auth">true</prop>
 * <prop key="mail.smtp.starttls.enable">true</prop> </props> </property>
 * </bean>
 */
