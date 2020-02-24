package com.github.dkurata38.open_web_library.web

import org.springframework.context.annotation.Bean
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect

class ThymeleafConfig {
	@Bean
	fun java8TimeDialect(): Java8TimeDialect {
		return Java8TimeDialect()
	}
}
