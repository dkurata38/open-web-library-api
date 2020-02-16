package com.github.dkurata38.open_web_library.client

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate


@ComponentScan(basePackages = ["com.github.dkurata38.open_web_library.client.*"])
@Configuration
class ClientModule {
	@Bean
	fun restTemplate(): RestTemplate {
		return RestTemplateBuilder().build()
	}
}
