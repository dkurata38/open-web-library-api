package com.github.dkurata38.open_web_library.google_books

import com.github.dkurata38.open_web_library.library_domain.BookCollation
import com.github.dkurata38.open_web_library.library_domain.BookCollationRepository
import com.github.dkurata38.open_web_library.library_domain.Isbn13
import org.springframework.web.client.RestOperations
import java.time.LocalDate

class GoogleBookCollationRepository(private val restOperations: RestOperations, private val googleBookProperties: GoogleBookProperties): BookCollationRepository {
	override fun findByIsbn(isbn: String): BookCollation? {
		val hyphenLessIsbn = isbn.replace("-", "")
		val uri = "https://www.googleapis.com/books/v1/volumes?q=isbn:${hyphenLessIsbn}&key=${googleBookProperties.apiKey}"
		return restOperations.getForObject(uri, Response::class.java)?.let { response -> toBookCollation(isbn, response) }
	}

	private fun toBookCollation(isbn: String, response: Response): BookCollation? {
		if (response.totalItems == 0) {
			return null;
		}
		val volumeInfo = response.items[0].volumeInfo
		return BookCollation(volumeInfo.title, volumeInfo.authors[0], volumeInfo.publisher, volumeInfo.publishedDate, volumeInfo.language, Isbn13(isbn))
	}
}


private data class Response(val items: List<Item>, val totalItems: Int)

private data class Item(val volumeInfo: VolumeInfo)

private data class VolumeInfo(val title: String, val subtitle: String, val authors: List<String>, val publisher: String, val publishedDate: LocalDate, val language: String, val industryIdentifiers: List<IndustryIdentifier>)

private data class IndustryIdentifier(val type: String, val identifier: String)


