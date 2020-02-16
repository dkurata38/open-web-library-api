package com.github.dkurata38.open_web_library.client.book

import com.github.dkurata38.open_web_library.domain.book.BookSummary
import com.github.dkurata38.open_web_library.domain.book.ISBN

internal interface BookSearchApiAdaptor {
	fun getByISBN(isbn: ISBN): BookSummary?
}
