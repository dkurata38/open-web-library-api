package com.github.dkurata38.open_web_library.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests(authorize -> authorize
						.antMatchers("/css/**", "/js/**", "/login", "/register_member/**").permitAll()
						.antMatchers("/**").authenticated())
				.formLogin(formLogin -> formLogin
						.loginPage("/login")
						.defaultSuccessUrl("/library_items", true)
				);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
