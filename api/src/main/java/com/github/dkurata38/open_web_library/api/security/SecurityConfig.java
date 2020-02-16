package com.github.dkurata38.open_web_library.api.security;

import com.github.dkurata38.open_web_library.application.security.MemberDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationEntryPointFailureHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public static final String LOGIN_PROCESSING_PATH = "/login";
	public static final String USER_NAME_PARAMETER = "user_id";
	public static final String PASSWORD_PARAMETER = "password";

	@Value("${application.security.cors-permit-host}")
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
				.successHandler(new JwtAuthenticationSuccessHandler(jwtTokenService))
				.failureHandler(new AuthenticationEntryPointFailureHandler(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
		.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
		.and()
			.csrf()
			.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			.ignoringAntMatchers(LOGIN_PROCESSING_PATH)
		.and()
			.cors()
			.configurationSource(corsConfigurationSource())
		.and()
			.addFilterBefore(new JwtAuthenticationFilter(jwtTokenService, memberDetailService), UsernamePasswordAuthenticationFilter.class)
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowedOrigins(List.of(corsPermitHost));
		corsConfiguration.setAllowedMethods(List.of(HttpMethod.DELETE.name(), HttpMethod.GET.name(), HttpMethod.HEAD.name(), HttpMethod.POST.name(), HttpMethod.PUT.name()));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.setCorsConfigurations(Map.of("*", corsConfiguration));
		return urlBasedCorsConfigurationSource;
	}

	private final JwtTokenService jwtTokenService;

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
