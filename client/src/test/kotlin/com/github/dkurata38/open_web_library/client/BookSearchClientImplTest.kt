package com.github.dkurata38.open_web_library.client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import com.github.dkurata38.open_web_library.client.book.BookSearchClientImpl
import com.github.dkurata38.open_web_library.domain.book.ISBN
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@SpringBootTest
class BookSearchClientImplTest(@Autowired private val bookSearchClientImpl: BookSearchClientImpl) {

	@Test
	fun getByISBN() {
		val isbn = ISBN.extractFromText("ISBN978-4-7981-3161-0")
		val bookSummary = bookSearchClientImpl.getByISBN(isbn)
		Assertions.assertNotNull(bookSummary)
	}
}
