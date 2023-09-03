/**
 *
 *//*
	 * package com.karimerri.aladin_api.validators;
	 *
	 * import org.springframework.beans.factory.annotation.Autowired; import
	 * org.springframework.context.MessageSource; import
	 * org.springframework.stereotype.Component; import
	 * org.springframework.validation.Errors; import
	 * org.springframework.validation.Validator;
	 *
	 * import com.karimerri.aladin_api.entities.User; import
	 * com.karimerri.aladin_api.securities.SecurityService;
	 *
	 * @Component public class UserValidator implements Validator {
	 *
	 * @Autowired protected MessageSource messageSource;
	 *
	 * @Autowired protected SecurityService securityService;
	 *
	 * @Override public boolean supports(Class<?> clazz) { return
	 * User.class.isAssignableFrom(clazz); }
	 *
	 * @Override public void validate(Object target, Errors errors) { final User
	 * user = (User) target; final String email = user.getEmail(); final User
	 * userByEmail = securityService.findUserByEmail(email); if (userByEmail !=
	 * null) errors.rejectValue("email", "error.exists", new Object[] { email },
	 * "Email " + email + " already in use"); }
	 *
	 * }
	 */