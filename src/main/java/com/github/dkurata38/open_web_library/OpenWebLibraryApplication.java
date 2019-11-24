package com.github.dkurata38.open_web_library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.github.dkurata38.open_web_library.*.*")
public class OpenWebLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenWebLibraryApplication.class, args);
	}

}
