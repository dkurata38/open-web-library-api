package com.github.dkurata38.open_web_library.infra.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.dkurata38.open_web_library.domain.book.BookSummary;
import com.github.dkurata38.open_web_library.domain.book.ISBN;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.function.BiFunction;

@Component
@RequiredArgsConstructor
public class OpenBDClient implements BookSearchClient {
	private final RestTemplate restTemplate;

	private static String URI_TEMPLATE = "https://api.openbd.jp/v1/get?isbn=%s";

	private static BiFunction<ISBN, BookSummaryResponse, BookSummary> converter = (isbn, bookSummaryResponse) -> {
		Summary summary = bookSummaryResponse.getSummary();
		LocalDate publishedDate = LocalDate.parse(summary.getPubdate(), DateTimeFormatter.ofPattern("yyyyMMdd"));
		return new BookSummary(isbn, summary.getTitle(), summary.getAuthor(), summary.getPublisher(), publishedDate, summary.cover);
	};

	@Override
	public Optional<BookSummary> getByISBN(ISBN isbn) {
		String uri = String.format(URI_TEMPLATE, isbn.getValue());
		BookSummaryResponse[] responses = restTemplate.getForObject(uri, BookSummaryResponse[].class);
		return Optional.ofNullable(responses)
				.filter(res -> res.length > 0)
				.map(res -> res[0])
				.map(res -> converter.apply(isbn, res));
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	@Data
	static class BookSummaryResponse {
		private Summary summary;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	@Data
	static class Summary {
		private String title;
		private String publisher;
		private String pubdate;
		private String cover;
		private String author;

	}
}
