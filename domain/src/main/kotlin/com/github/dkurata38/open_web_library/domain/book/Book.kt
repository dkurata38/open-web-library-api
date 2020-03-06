package com.github.dkurata38.open_web_library.domain.book

class Book(val bookId: BookId) {
	companion object {
		fun createInstance(): Book {
			return Book(BookId.issue())
		}
	}
}
