package com.github.dkurata38.open_web_library.client;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import static java.util.stream.Collectors.*;

//@Slf4j
//@ComponentScan(basePackages = {"com.github.dkurata38.open_web_library.client.*"})
//@Configuration
//public class ClientConfig {
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplateBuilder().build();
//	}
//}
