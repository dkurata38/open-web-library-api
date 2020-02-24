package com.github.dkurata38.open_web_library.application.book

import com.github.dkurata38.open_web_library.domain.book.BookSummary
import com.github.dkurata38.open_web_library.domain.book.ISBN
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.core.io.Resource
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository,
				  private val imageCognitionClient: ImageCognitionClient,
				  private val bookSearchClient: BookSearchClient) {

	companion object {
		val logger: Logger = LoggerFactory.getLogger(BookService::class.java)
	}

//	public Iterable<Book> findBy() {
//		return bookRepository.findAll()
//	}

	fun findByImage(resource: Resource): BookSummary? {
		return extractISBNFromImage(resource)
				?.let { findByISBN(it) }
	}

	fun extractISBNFromImage(resource: Resource): ISBN? {
		val text = imageCognitionClient.extractTextFromImage(resource)
		return runCatching { ISBN.extractFromText(text) }
				.onFailure { logger.error("ISBN parseError: {}", it) }
				.getOrNull()
	}

	fun findByISBN(isbn: ISBN): BookSummary? {
		return bookSearchClient.getByISBN(isbn)
	}
}
