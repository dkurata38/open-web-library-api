package com.github.dkurata38.open_web_library.client;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.github.dkurata38.open_web_library.client.book.BookSearchClient;
import com.github.dkurata38.open_web_library.domain.book.ISBN;

@SpringBootTest
@Slf4j
class BookSearchClientTest {

	@Autowired
	private BookSearchClient bookSearchClient;

//	@Test
	void getByISBN() {
		ISBN isbn = ISBN.ofBarcode("ISBN978-4-7981-3161-0");
		bookSearchClient.getByISBN(isbn)
			.ifPresent(bookSummary -> log.info(bookSummary.toString()));
	}
}
