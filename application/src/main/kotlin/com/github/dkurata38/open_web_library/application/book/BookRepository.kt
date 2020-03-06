package com.github.dkurata38.open_web_library.application.book

import com.github.dkurata38.open_web_library.domain.book.Book
import com.github.dkurata38.open_web_library.domain.book.ISBN

interface BookRepository {
	fun findByISBN(isbn: ISBN): Book?

	fun save(book: Book)
}
