package com.karimerri.aladin_api.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	private final Logger logger = LogManager.getLogger(SecurityConfiguration.class);
	@Autowired
	ApplicationConfig applicationConfig;

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.trace("oauth2 security enabled : " + applicationConfig.getSecurity().isOauth2enabled());

		if (applicationConfig.getSecurity().isOauth2enabled())
			http.csrf().disable().headers().frameOptions().disable().and().formLogin().loginPage("/login")
					.failureUrl("/login?error").and().authorizeRequests()
					.antMatchers(HttpMethod.POST, "/register", "/browser/**", "login", "/customer/new", "/oauth/token")
					.permitAll().antMatchers(HttpMethod.GET, "/register", "/browser/**", "login", "/oauth/token")
					.permitAll()
					.antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security",
							"/swagger-ui.html", "/webjars/**")
					.permitAll().antMatchers(HttpMethod.POST).hasRole("ADMIN").antMatchers(HttpMethod.DELETE)
					.hasRole("ADMIN").antMatchers(HttpMethod.PATCH).hasRole("ADMIN").antMatchers(HttpMethod.PUT)
					.hasRole("ADMIN").anyRequest().authenticated();
		else {
			http.csrf().disable().authorizeRequests().anyRequest().permitAll();
			http.anonymous().authorities("ADMIN");

		}
	}

}
