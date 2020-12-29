package com.github.dkurata38.open_web_library.library_infra

import com.github.dkurata38.open_web_library.library_domain.Book
import com.github.dkurata38.open_web_library.library_domain.BookId
import com.github.dkurata38.open_web_library.library_domain.BookRepository
import com.github.dkurata38.open_web_library.library_domain.Isbn13

class BookRepositoryImpl: BookRepository {
	private val values: MutableList<Book> = mutableListOf();
	override fun findById(id: BookId): Book? {
		return values.find { e -> e.id == id }
	}

	internal fun findByIds(ids: List<BookId>): List<Book> {
		return values.filter { e -> ids.contains(e.id) }
	}

	override fun findByIsbn(isbn: Isbn13): Book? {
		return values.find { e -> e.bookCollation.isbn13 == isbn }
	}

	override fun insert(book: Book) {
		values.add(book)
	}

	override fun updateById(book: Book) {
		values.replaceAll { e -> if (e.id == book.id) e.copy(bookCollation = book.bookCollation) else e }
	}
}
