package com.karimerri.aladin_api.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import com.karimerri.aladin_api.entities.Property;
import com.karimerri.aladin_api.repositories.PropertyRepository;

@Component
@PropertySources({ @PropertySource("database.properties"), @PropertySource("application.properties"), })
@ConfigurationProperties(prefix = "ldn.props")
public class ApplicationConfig {

	public class Mail {
		private String defaultTo;
		private String cC;
		private String alertSubject;
		private String alertResend;
		private String alertResendFrequency;
		private String warningSubject;
		private String warningResend;
		private String warningResendFrequency;

		public Mail() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getAlertResend() {
			return alertResend;
		}

		public String getAlertResendFrequency() {
			return alertResendFrequency;
		}

		public String getcC() {
			return cC;
		}

		public String getDefaultTo() {
			return defaultTo;
		}

		public String getMailalertSubject() {
			return alertSubject;
		}

		public String getWarningResend() {
			return warningResend;
		}

		public String getWarningResendFrequency() {
			return warningResendFrequency;
		}

		public String getWarningSubject() {
			return warningSubject;
		}

		public void setAlertResend(String mailalertresend) {
			alertResend = mailalertresend;
		}

		public void setAlertResendFrequency(String mailalertresendfrequency) {
			alertResendFrequency = mailalertresendfrequency;
		}

		public void setcC(String mailcc) {
			cC = mailcc;
		}

		public void setDefaultTo(String maildefaultto) {
			defaultTo = maildefaultto;
		}

		public void setMailalertSubject(String mailalertsubject) {
			alertSubject = mailalertsubject;
		}

		public void setWarningResend(String mailwarningresend) {
			warningResend = mailwarningresend;
		}

		public void setWarningResendFrequency(String mailwarningresendfrequency) {
			warningResendFrequency = mailwarningresendfrequency;
		}

		public void setWarningSubject(String mailwarningsubject) {
			warningSubject = mailwarningsubject;
		}

	}

	public class Notification {
		private int alertDays;
		private int warningDays;

		public Notification() {
			super();
		}

		public int getAlertDays() {
			return alertDays;
		}

		public int getWarningDays() {
			return warningDays;
		}

		public void setAlertDays(int alertdays) {
			alertDays = alertdays;
		}

		public void setWarningDays(int warningdays) {
			warningDays = warningdays;
		}

	}

	public class Security {

		private boolean oauth2enabled = true;

		public boolean isOauth2enabled() {
			return oauth2enabled;
		}

		public void setOauth2enabled(boolean oauth2enabled) {
			this.oauth2enabled = oauth2enabled;
		}

	}

	private final Logger logger = LogManager.getLogger(ApplicationConfig.class);

	private Notification notification;

	private Mail mail;

	private Security security;

	public ApplicationConfig(PropertyRepository repository) {

		notification = new Notification();
		mail = new Mail();
		security = new Security();

		notification.setAlertDays(
				Integer.parseInt(repository.findByName("ldn.props.alert.days").orElse(new Property()).getValue()));
		logger.debug("property alertDays loaded :" + notification.alertDays);

		notification.setWarningDays(
				Integer.parseInt(repository.findByName("ldn.props.warning.days").orElse(new Property()).getValue()));
		logger.debug("property warningDays loaded :" + notification.warningDays);

		mail.setDefaultTo(repository.findByName("ldn.props.mail.default.to").orElse(new Property()).getValue());
		logger.debug("property defaultTo loaded :" + mail.getDefaultTo());

		mail.setcC(repository.findByName("ldn.props.mail.cc").orElse(new Property()).getValue());
		logger.debug("property CC loaded :" + mail.getcC());

		mail.setMailalertSubject(
				repository.findByName("ldn.props.mail.alert.subject").orElse(new Property()).getValue());
		logger.debug("property mailalertubject loaded :" + mail.getMailalertSubject());

		mail.setAlertResend(
				repository.findByName("dpmanager.props.mail.alert.resend").orElse(new Property()).getValue());
		logger.debug("property alertResend loaded :" + mail.getAlertResend());

		mail.setAlertResendFrequency(
				repository.findByName("ldn.props.mail.alert.resend.frequency").orElse(new Property()).getValue());
		logger.debug("property alertResendFrequency loaded :" + mail.getAlertResendFrequency());

		mail.setWarningSubject(
				repository.findByName("ldn.props.mail.warning.subject").orElse(new Property()).getValue());
		logger.debug("property warningSubject loaded :" + mail.getWarningSubject());

		mail.setWarningResend(
				repository.findByName("dpmanager.props.mail.warning.resend").orElse(new Property()).getValue());
		logger.debug("property warningResend loaded :" + mail.getWarningResend());

		mail.setWarningResendFrequency(
				repository.findByName("ldn.props.mail.warning.resend.frequency").orElse(new Property()).getValue());
		logger.debug("property warningResendFrequency loaded :" + mail.getWarningResendFrequency());

	}

	public Mail getMail() {
		return mail;
	}

	public Notification getNotification() {
		return notification;
	}

	public Security getSecurity() {
		return security;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}
}
