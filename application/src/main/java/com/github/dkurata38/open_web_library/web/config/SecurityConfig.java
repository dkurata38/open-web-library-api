package com.github.dkurata38.open_web_library.web.config;

import com.github.dkurata38.open_web_library.application.security.MemberDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationEntryPointFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@ConfigurationProperties(prefix = "application.security")
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public static final String LOGIN_PROCESSING_PATH = "/login";
	public static final String USER_NAME_PARAMETER = "user_id";
	public static final String PASSWORD_PARAMETER = "password";

	private String corsPermitHost;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers(LOGIN_PROCESSING_PATH).permitAll()
			.anyRequest().authenticated()
		.and()
			.exceptionHandling()
				.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
				// accessDeniedHandler?
		.and()
			.formLogin()
				.loginProcessingUrl(LOGIN_PROCESSING_PATH).permitAll()
				.usernameParameter(USER_NAME_PARAMETER)
				.passwordParameter(PASSWORD_PARAMETER)
				.successHandler(new ReturningHttpOkHandler())
				// success handler return 200
				.failureHandler(new AuthenticationEntryPointFailureHandler(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
		.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
		.and()
			.csrf()
			.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			.ignoringAntMatchers(LOGIN_PROCESSING_PATH);

	}

	public static class ReturningHttpOkHandler implements AuthenticationSuccessHandler {

		@Override
		public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain, final Authentication authentication) throws IOException, ServletException {
			response.setStatus(HttpStatus.OK.value());
		}

		@Override
		public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException, ServletException {
			response.setStatus(HttpStatus.OK.value());
		}
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	private final MemberDetailService memberDetailService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(memberDetailService);
	}
}
