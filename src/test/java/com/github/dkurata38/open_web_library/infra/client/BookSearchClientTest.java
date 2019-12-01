package com.github.dkurata38.open_web_library.infra.client;

import com.github.dkurata38.open_web_library.domain.book.BookSummary;
import com.github.dkurata38.open_web_library.domain.book.ISBN;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BookSearchClientTest {

	@Autowired
	private BookSearchClient bookSearchClient;

	@Test
	void getByISBN() {
		ISBN isbn = ISBN.ofBarcode("ISBN978-4-7981-3161-0");
		bookSearchClient.getByISBN(isbn)
			.ifPresent(bookSummary -> log.info(bookSummary.toString()));
	}
}
