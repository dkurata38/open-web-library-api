package com.github.dkurata38.open_web_library.web.security;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;

@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BearerToken {
	private final String value;

	public static BearerToken createInstance(@NonNull String token) {
		String value = String.format("Bearer %s", token);
		return new BearerToken(value);
	}
}
