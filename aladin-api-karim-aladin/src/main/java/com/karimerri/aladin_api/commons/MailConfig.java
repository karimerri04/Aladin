package com.karimerri.aladin_api.commons;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

	private Properties getMailProperties() {
		final Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.auth", "false");
		properties.setProperty("mail.smtp.starttls.enable", "false");
		properties.setProperty("mail.debug", "false");
		return properties;
	}

	@Bean
	public JavaMailSender javaMailService() {
		final JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

		javaMailSender.setHost("myHost");
		javaMailSender.setPort(25);

		javaMailSender.setJavaMailProperties(getMailProperties());

		return javaMailSender;
	}
}
