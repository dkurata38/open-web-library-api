package com.github.dkurata38.open_web_library.client.book

import com.github.dkurata38.open_web_library.application.book.BookSearchClient
import com.github.dkurata38.open_web_library.domain.book.BookSummary
import com.github.dkurata38.open_web_library.domain.book.ISBN
import org.springframework.stereotype.Component

@Component
class BookSearchClientImpl internal constructor(private val bookSearchApiAdaptors: Set<BookSearchApiAdaptor>) : BookSearchClient {
	override fun getByISBN(isbn: ISBN): BookSummary? {
		for (bookSearchApiAdaptor in bookSearchApiAdaptors) {
			val bookSummary = bookSearchApiAdaptor.getByISBN(isbn)
			if (bookSummary != null) {
				return bookSummary
			}
		}
		return null
	}
}
