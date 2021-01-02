package com.github.dkurata38.open_web_library.web.infrastructure.library;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "google-book")
@ConstructorBinding
public class GoogleBookProperties {
	private final String apiKey;
	public GoogleBookProperties(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getApiKey() {
		return apiKey;
	}
}
