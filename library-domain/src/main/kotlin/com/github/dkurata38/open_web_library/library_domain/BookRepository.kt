package com.github.dkurata38.open_web_library.library_domain

interface BookRepository {
	fun findById(id: BookId): Book?
	fun findByIsbn(isbn: Isbn13): Book?
	fun insert(book: Book)
	fun updateById(book: Book)
}
