package com.github.dkurata38.open_web_library.repository.book

import com.github.dkurata38.open_web_library.application.book.BookRepository
import com.github.dkurata38.open_web_library.domain.book.Book
import com.github.dkurata38.open_web_library.domain.book.ISBN
import org.springframework.stereotype.Repository

@Repository
class BookRepositoryImpl : BookRepository {
	override fun findByISBN(isbn: ISBN): Book? {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun save(book: Book) {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}
}
