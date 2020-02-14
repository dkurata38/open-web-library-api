package com.github.dkurata38.open_web_library.client.book;

import com.github.dkurata38.open_web_library.domain.book.BookSummary
import com.github.dkurata38.open_web_library.domain.book.ISBN
import org.springframework.stereotype.Component

@Component
class BookSearchClient(private val openBDClient: OpenBDClient) {
	fun getByISBN(isbn: ISBN): BookSummary? {
		return openBDClient.getByISBN(isbn)
	}
}
