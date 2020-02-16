package com.github.dkurata38.open_web_library.client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import com.github.dkurata38.open_web_library.client.book.BookSearchClient
import com.github.dkurata38.open_web_library.domain.book.ISBN
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@SpringBootTest
class BookSearchClientTest (@Autowired private val bookSearchClient: BookSearchClient) {

	@Test
	fun getByISBN() {
		val isbn = ISBN.ofBarcode("ISBN978-4-7981-3161-0")
		val bookSummary = bookSearchClient.getByISBN(isbn)
		Assertions.assertNotNull(bookSummary)
	}
}
