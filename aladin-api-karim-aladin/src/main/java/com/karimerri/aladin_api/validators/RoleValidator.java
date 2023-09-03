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
	 * import com.karimerri.aladin_api.entities.Role; import
	 * com.karimerri.aladin_api.securities.SecurityService;
	 *
	 * @Component public class RoleValidator implements Validator {
	 *
	 * @Autowired protected MessageSource messageSource;
	 *
	 * @Autowired protected SecurityService securityService;
	 *
	 * @Override public boolean supports(Class<?> clazz) { return
	 * Role.class.isAssignableFrom(clazz); }
	 *
	 * @Override public void validate(Object target, Errors errors) { final Role
	 * role = (Role) target; final String name = role.getName(); final Role
	 * RoleByName = securityService.getRoleByName(name); if (RoleByName != null)
	 * errors.rejectValue("name", "error.exists", new Object[] { name }, "Role " +
	 * name + " already exists"); }
	 *
	 * }
	 */