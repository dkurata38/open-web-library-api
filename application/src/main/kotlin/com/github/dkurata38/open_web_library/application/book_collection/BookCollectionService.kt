package com.github.dkurata38.open_web_library.application.book_collection

import com.github.dkurata38.open_web_library.application.book.BookRepository
import com.github.dkurata38.open_web_library.domain.book.Book
import com.github.dkurata38.open_web_library.domain.book.ISBN
import com.github.dkurata38.open_web_library.domain.book_collection.BookCollection
import com.github.dkurata38.open_web_library.domain.member.MemberId
import org.springframework.stereotype.Service

@Service
class BookCollectionService(private val bookRepository: BookRepository,
							private val bookCollectionRepository: BookCollectionRepository) {

	fun add(memberId: MemberId, isbn: ISBN) {
		val savedBook = bookRepository.findByISBN(isbn)

		val bookId = if (savedBook != null) {
			savedBook.bookId
		} else {
			val newBook = Book.createInstance()
			bookRepository.save(newBook)
			newBook.bookId
		}
		bookCollectionRepository.save(BookCollection.createInstance(memberId, bookId))
	}
}
