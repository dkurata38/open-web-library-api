package com.github.dkurata38.open_web_library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = "com.github.dkurata38.open_web_library.*.*")
@EnableConfigurationProperties
public class OpenWebLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenWebLibraryApplication.class, args);
	}

}
