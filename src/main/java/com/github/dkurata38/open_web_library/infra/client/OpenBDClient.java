package com.github.dkurata38.open_web_library.infra.client;

import com.github.dkurata38.open_web_library.domain.book.ISBN;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class OpenBDClient implements BookSearchClient {
	private final RestTemplate restTemplate;

	private static String URI_TEMPLATE = "https://api.openbd.jp/v1/get?isbn=%s";

	@Override
	public String getByISBN(ISBN isbn) {
		String uri = String.format(URI_TEMPLATE, isbn.getValue());
		String s = restTemplate.getForObject(uri, String.class);
		return s;
	}
}
