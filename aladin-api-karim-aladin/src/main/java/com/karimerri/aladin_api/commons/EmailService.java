package com.karimerri.aladin_api.commons;

import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karimerri.aladin_api.utils.AlaDinException;

@Service
@Transactional
//@Component
public class EmailService {
	private static final AlaDinLogger logger = AlaDinLogger.getLogger(EmailService.class);
	@Autowired
	JavaMailSender javaMailSender;
	@Value("${support.email}")
	String supportEmail;

	public void sendEmail(String to, String subject, String message) throws MessagingException {

		final SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	
		try {
			simpleMailMessage.setTo(to);
			simpleMailMessage.setFrom(supportEmail);
			simpleMailMessage.setSubject(subject);
			simpleMailMessage.setText(message);

			logger.info(subject);
			logger.info(to);
			logger.info(message);

			javaMailSender.send(simpleMailMessage);

		} catch (MailException e) {
			logger.error(e);
			throw new AlaDinException("Unable to send email");
		}
	}

}
