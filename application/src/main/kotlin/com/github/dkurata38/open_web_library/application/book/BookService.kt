package com.github.dkurata38.open_web_library.application.book

import com.github.dkurata38.open_web_library.domain.book.BookSummary
import com.github.dkurata38.open_web_library.domain.book.ISBN

import org.springframework.core.io.Resource
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository,
				  private val imageCognitionClient: ImageCognitionClient,
				  private val bookSearchClient: BookSearchClient)  {

//	public Iterable<Book> findBy() {
//		return bookRepository.findAll()
//	}

	fun findByImage(resource: Resource): BookSummary? {
		return extractISBNFromImage(resource)
				?.let { findByISBN(it) }
	}

	fun extractISBNFromImage(resource: Resource): ISBN? {
		val text = imageCognitionClient.extractTextFromImage(resource)
		return runCatching { ISBN.extractBarcodeFromText(text) }
				.getOrNull()
	}

	fun findByISBN(isbn: ISBN): BookSummary? {
		return bookSearchClient.getByISBN(isbn)
	}
}
