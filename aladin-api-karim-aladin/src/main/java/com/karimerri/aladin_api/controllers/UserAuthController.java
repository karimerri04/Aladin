/*
 * package com.karimerri.aladin_api.controllers;
 *
 * import static com.karimerri.aladin_api.utils.MessageCodes.
 * ERROR_INVALID_PASSWORD_RESET_REQUEST; import static
 * com.karimerri.aladin_api.utils.MessageCodes.
 * ERROR_PASSWORD_CONF_PASSWORD_MISMATCH; import static
 * com.karimerri.aladin_api.utils.MessageCodes.INFO_PASSWORD_RESET_LINK_SENT;
 * import static
 * com.karimerri.aladin_api.utils.MessageCodes.INFO_PASSWORD_UPDATED_SUCCESS;
 * import static com.karimerri.aladin_api.utils.MessageCodes.
 * LABEL_PASSWORD_RESET_EMAIL_SUBJECT;
 *
 * import javax.servlet.http.HttpServletRequest;
 *
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.servlet.mvc.support.RedirectAttributes; import
 * org.thymeleaf.TemplateEngine; import org.thymeleaf.context.Context;
 *
 * import com.karimerri.aladin_api.commons.EmailService; import
 * com.karimerri.aladin_api.securities.SecurityService; import
 * com.karimerri.aladin_api.utils.AlaDinException; import
 * com.karimerri.aladin_api.utils.WebUtils;
 *
 * @Controller public class UserAuthController extends AlaDinAdminBaseController
 * { private static final String viewPrefix = "public/";
 *
 * @Autowired protected SecurityService securityService;
 *
 * @Autowired protected EmailService emailService;
 *
 * @Autowired protected PasswordEncoder passwordEncoder;
 *
 * @Autowired protected TemplateEngine templateEngine;
 *
 * @GetMapping(path = "/forgotPwd") public String forgotPwd() { return
 * viewPrefix + "forgotPwd"; }
 *
 * @PostMapping(path = "/forgotPwd") public String
 * handleForgotPwd(HttpServletRequest request, RedirectAttributes
 * redirectAttributes) { final String email = request.getParameter("email"); try
 * { final String token = securityService.resetPassword(email); final String
 * resetPwdURL = WebUtils.getURLWithContextPath(request) + "/resetPwd?email=" +
 * email + "&token=" + token; logger.debug(resetPwdURL);
 * sendForgotPasswordEmail(email, resetPwdURL);
 * redirectAttributes.addFlashAttribute("msg",
 * getMessage(INFO_PASSWORD_RESET_LINK_SENT)); } catch (final AlaDinException e)
 * { logger.error(e); redirectAttributes.addFlashAttribute("msg",
 * e.getMessage()); } return "redirect:/forgotPwd"; }
 *
 * @PostMapping(path = "/resetPwd") public String
 * handleResetPwd(HttpServletRequest request, Model model, RedirectAttributes
 * redirectAttributes) { try { final String email =
 * request.getParameter("email"); final String token =
 * request.getParameter("token"); final String password =
 * request.getParameter("password"); final String confPassword =
 * request.getParameter("confPassword"); if (!password.equals(confPassword)) {
 * model.addAttribute("email", email); model.addAttribute("token", token);
 * model.addAttribute("msg", getMessage(ERROR_PASSWORD_CONF_PASSWORD_MISMATCH));
 * return viewPrefix + "resetPwd"; } final String encodedPwd =
 * passwordEncoder.encode(password); securityService.updatePassword(email,
 * token, encodedPwd);
 *
 * redirectAttributes.addFlashAttribute("msg",
 * getMessage(INFO_PASSWORD_UPDATED_SUCCESS)); } catch (final AlaDinException e)
 * { logger.error(e); redirectAttributes.addFlashAttribute("msg",
 * getMessage(ERROR_INVALID_PASSWORD_RESET_REQUEST)); } return
 * "redirect:/login"; }
 *
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 *
 * @GetMapping(path = "/resetPwd") public String resetPwd(HttpServletRequest
 * request, Model model, RedirectAttributes redirectAttributes) { final String
 * email = request.getParameter("email"); final String token =
 * request.getParameter("token");
 *
 * final boolean valid = securityService.verifyPasswordResetToken(email, token);
 * if (valid) { model.addAttribute("email", email); model.addAttribute("token",
 * token); return viewPrefix + "resetPwd"; } else {
 * redirectAttributes.addFlashAttribute("msg",
 * getMessage(ERROR_INVALID_PASSWORD_RESET_REQUEST)); return "redirect:/login";
 * }
 *
 * }
 *
 * protected void sendForgotPasswordEmail(String email, String resetPwdURL) {
 * try {
 *
 * // Prepare the evaluation context final Context ctx = new Context();
 * ctx.setVariable("resetPwdURL", resetPwdURL);
 *
 * // Create the HTML body using Thymeleaf final String htmlContent =
 * templateEngine.process("forgot-password-email", ctx);
 *
 * emailService.sendEmail(email, getMessage(LABEL_PASSWORD_RESET_EMAIL_SUBJECT),
 * htmlContent); } catch (final AlaDinException e) { logger.error(e); } } }
 */