/**
 *
 *//*
	 * package com.karimerri.aladin_api.controllers;
	 *
	 * import java.util.ArrayList; import java.util.HashMap; import java.util.List;
	 * import java.util.Map;
	 *
	 * import javax.validation.Valid;
	 *
	 * import org.springframework.beans.factory.annotation.Autowired; import
	 * org.springframework.security.crypto.password.PasswordEncoder; import
	 * org.springframework.stereotype.Controller; import
	 * org.springframework.ui.Model; import
	 * org.springframework.validation.BindingResult; import
	 * org.springframework.web.bind.annotation.GetMapping; import
	 * org.springframework.web.bind.annotation.ModelAttribute; import
	 * org.springframework.web.bind.annotation.PathVariable; import
	 * org.springframework.web.bind.annotation.PostMapping; import
	 * org.springframework.web.servlet.mvc.support.RedirectAttributes;
	 *
	 * import com.karimerri.aladin_api.entities.Role; import
	 * com.karimerri.aladin_api.entities.User; import
	 * com.karimerri.aladin_api.securities.SecurityService; import
	 * com.karimerri.aladin_api.validators.UserValidator;
	 *
	 * @Controller //@Secured(SecurityUtil.MANAGE_USERS) public class UserController
	 * extends AlaDinAdminBaseController { private static final String viewPrefix =
	 * "users/";
	 *
	 * @Autowired protected SecurityService securityService;
	 *
	 * @Autowired private UserValidator userValidator;
	 *
	 * @Autowired protected PasswordEncoder passwordEncoder;
	 *
	 * @PostMapping(path = "/users") public String
	 * createUser(@Valid @ModelAttribute("user") User user, BindingResult result,
	 * Model model, RedirectAttributes redirectAttributes) {
	 * userValidator.validate(user, result); if (result.hasErrors()) return
	 * viewPrefix + "create_user"; final String password = user.getPassword(); final
	 * String encodedPwd = passwordEncoder.encode(password);
	 * user.setPassword(encodedPwd); final User persistedUser =
	 * securityService.createUser(user);
	 * logger.debug("Created new User with id : {} and name : {}",
	 * persistedUser.getId(), persistedUser.getName());
	 * redirectAttributes.addFlashAttribute("info", "User created successfully");
	 * return "redirect:/users"; }
	 *
	 * @GetMapping(path = "/users/new") public String createUserForm(Model model) {
	 * final User user = new User(); model.addAttribute("user", user); //
	 * model.addAttribute("rolesList",securityService.getAllRoles());
	 *
	 * return viewPrefix + "create_user"; }
	 *
	 * @GetMapping(path = "/users/{id}") public String editUserForm(@PathVariable
	 * Integer id, Model model) { final User user = securityService.getUserById(id);
	 * final Map<Integer, Role> assignedRoleMap = new HashMap<>(); final List<Role>
	 * roles = user.getRoles(); for (final Role role : roles)
	 * assignedRoleMap.put(role.getId(), role); final List<Role> userRoles = new
	 * ArrayList<>(); final List<Role> allRoles = securityService.getAllRoles(); for
	 * (final Role role : allRoles) if (assignedRoleMap.containsKey(role.getId()))
	 * userRoles.add(role); else userRoles.add(null); user.setRoles(userRoles);
	 * model.addAttribute("user", user); //
	 * model.addAttribute("rolesList",allRoles); return viewPrefix + "edit_user"; }
	 *
	 * @GetMapping(path = "/users") public List<User> listUsers() { return
	 * securityService.getAllUsers(); }
	 *
	 * @ModelAttribute("rolesList") public List<Role> rolesList() { return
	 * securityService.getAllRoles(); }
	 *
	 * @PostMapping(path = "/users/{id}") public String
	 * updateUser(@ModelAttribute("user") User user, BindingResult result, Model
	 * model, RedirectAttributes redirectAttributes) { if (result.hasErrors())
	 * return viewPrefix + "edit_user"; final User persistedUser =
	 * securityService.updateUser(user);
	 * logger.debug("Updated user with id : {} and name : {}",
	 * persistedUser.getId(), persistedUser.getName());
	 * redirectAttributes.addFlashAttribute("info", "User updates successfully");
	 * return "redirect:/users"; }
	 *
	 * }
	 */