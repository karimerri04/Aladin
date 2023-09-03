package com.karimerri.aladin_api.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.karimerri.aladin_api.commons.AlaDinLogger;
import com.karimerri.aladin_api.commons.EmailService;
import com.karimerri.aladin_api.services.OtpService;
import com.karimerri.aladin_api.services.UserService;

@RestController
public class OtpController {
	private static final AlaDinLogger logger = AlaDinLogger.getLogger(EmailService.class);

	@Autowired
	public OtpService otpService;
	@Autowired
	public EmailService emailService;

	@Autowired
	public UserService userService;

	public String convertWithStream(Map<String, ?> map) {
		final String mapAsString = map.keySet().stream().map(key -> key + "=" + map.get(key))
				.collect(Collectors.joining(", ", "{", "}"));
		return mapAsString;
	}

	@GetMapping("/login/otp/sendotp")
	public String generateOtp(@RequestParam("number") String number) throws MessagingException {

		final int otp = otpService.generateOTP(number);
		logger.info("OTP : " + otp);
		// Generate The Template to send OTP;
		final Map<String, String> replacements = new HashMap<String, String>();
		replacements.put("user", number);
		replacements.put("otpnum", String.valueOf(otp));
		final String message = convertWithStream(replacements);
		emailService.sendEmail("karimerri@gmail.com", "OTP -SpringBoot", message);
		return String.valueOf(otp);
	}

	@RequestMapping(value = "/login/otp/verifyotp", method = RequestMethod.GET)
	public @ResponseBody String validateOtp(@RequestParam("otpnum") int otpnum) {
		final String SUCCESS = "Entered Otp is valid";
		final String FAIL = "Entered Otp is NOT valid. Please Retry!";
		SecurityContextHolder.getContext().getAuthentication();
		final String phoneNumber = userService.getUserByOpt(otpnum).getPhone();
		logger.info(" Otp Number : " + otpnum);
		// Validate the Otp
		if (otpnum >= 0) {
			final int serverOtp = otpService.getOtp(phoneNumber);
			if (serverOtp > 0) {
				if (otpnum == serverOtp) {
					otpService.clearOTP(phoneNumber);
					return ("Entered Otp is valid");
				} else
					return SUCCESS;
			} else
				return FAIL;
		} else
			return FAIL;
	}
}
