package com.github.dkurata38.open_web_library.web.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {
	@Bean
	public RestTemplate restTemplate () {
		return new RestTemplateBuilder().build();
	}
}
