package com.github.dkurata38.open_web_library.library_domain

import java.time.LocalDate
import java.time.LocalDateTime

class AddLibraryItemUseCaseImpl(private val addedLibraryItemRepository: AddedLibraryItemRepository, private val bookRepository: BookRepository) : AddLibraryItemUseCase {
	override fun add(title: String, authorName: String, publisherName: String, onSaleDate: LocalDate, language: String, isbn: String, ownerId: String) {
		val bookCollation = BookCollation(title, authorName, publisherName, onSaleDate, language, Isbn13(isbn))
		val maybeBook = bookRepository.findByIsbn(Isbn13(isbn))
		val addedAt = LocalDateTime.now()

		if (maybeBook == null) {
			val bookId = BookId.issue()
			val book = Book(bookId, bookCollation)
			bookRepository.insert(book)
			val addedLibraryItemId = AddedLibraryItemId.issue()
			val addedLibraryItem = AddedLibraryItem(addedLibraryItemId, bookId, OwnerId(ownerId), addedAt)
			addedLibraryItemRepository.save(addedLibraryItem)
		} else {
			val book = maybeBook.copy(bookCollation = bookCollation)
			bookRepository.updateById(book)
			val addedLibraryItemId = AddedLibraryItemId.issue()
			val addedLibraryItem = AddedLibraryItem(addedLibraryItemId, book.id, OwnerId(ownerId), addedAt)
			addedLibraryItemRepository.save(addedLibraryItem)
		}
	}
}
