package com.github.dkurata38.open_web_library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication(scanBasePackages = {
		"com.github.dkurata38.open_web_library.repository.*"
		, "com.github.dkurata38.open_web_library.client"
		, "com.github.dkurata38.open_web_library.application.*"
		, "com.github.dkurata38.open_web_library.web.*"
})
@ConfigurationPropertiesScan
public class OpenWebLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenWebLibraryApplication.class, args);
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
