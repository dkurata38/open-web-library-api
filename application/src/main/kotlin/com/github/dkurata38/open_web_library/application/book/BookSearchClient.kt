package com.github.dkurata38.open_web_library.application.book

import com.github.dkurata38.open_web_library.domain.book.BookSummary
import com.github.dkurata38.open_web_library.domain.book.ISBN

interface BookSearchClient {
	fun getByISBN(isbn: ISBN): BookSummary?
}
