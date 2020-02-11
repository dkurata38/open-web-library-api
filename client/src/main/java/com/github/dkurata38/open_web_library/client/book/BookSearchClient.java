package com.github.dkurata38.open_web_library.client.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import org.springframework.stereotype.Component;
import com.github.dkurata38.open_web_library.domain.book.BookSummary;
import com.github.dkurata38.open_web_library.domain.book.ISBN;

import static java.util.stream.Collectors.*;

@Slf4j
@RequiredArgsConstructor
@Component
public class BookSearchClient {
	private final OpenBDClient openBDClient;
	public Optional<BookSummary> getByISBN(ISBN isbn) {
		return openBDClient.getByISBN(isbn);
	}
}
