package com.github.dkurata38.open_web_library.web.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager


@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
	@Bean
	fun passwordEncoder(): PasswordEncoder {
		return BCryptPasswordEncoder()
	}

	override fun configure(http: HttpSecurity) {
		http
				.formLogin()
				.defaultSuccessUrl("/book_collections", true)

	}

	override fun configure(auth: AuthenticationManagerBuilder) {
		auth.inMemoryAuthentication()
				.withUser(User("kurata", passwordEncoder().encode("password"), AuthorityUtils.createAuthorityList("USER")))
	}

	@Bean
	override fun userDetailsService(): UserDetailsService {
		val user = User("kurata", passwordEncoder().encode("password"), AuthorityUtils.createAuthorityList("USER"))
		return InMemoryUserDetailsManager(user)
	}
}
