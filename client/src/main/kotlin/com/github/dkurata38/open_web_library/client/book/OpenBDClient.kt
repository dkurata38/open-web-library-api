package com.github.dkurata38.open_web_library.client.book

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.github.dkurata38.open_web_library.application.book.BookSearchClient
import com.github.dkurata38.open_web_library.domain.book.BookSummary
import com.github.dkurata38.open_web_library.domain.book.ISBN
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Component
internal class OpenBDClient(private val restTemplate: RestTemplate) : BookSearchApiAdaptor {
	companion object {
		private const val URI_TEMPLATE = "https://api.openbd.jp/v1/get?isbn=%s"
		val converter: (ISBN, BookSummaryResponse) -> BookSummary = { isbn: ISBN, bookSummaryResponse: BookSummaryResponse ->
			val summary = bookSummaryResponse.summary
			val publishedDate = LocalDate.parse(summary.pubdate, DateTimeFormatter.ofPattern("yyyyMMdd"))
			BookSummary(isbn, summary.title, summary.author, summary.publisher, publishedDate, summary.cover)
		}
	}

	override fun getByISBN(isbn: ISBN): BookSummary? {
		val uri = String.format(URI_TEMPLATE, isbn.value)
		val responses = restTemplate.getForObject(uri, Array<BookSummaryResponse>::class.java)
		return responses
				?.firstOrNull()
				?.let { converter.invoke(isbn, it) }
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	data class BookSummaryResponse(var summary: Summary)

	@JsonIgnoreProperties(ignoreUnknown = true)
	data class Summary(val title: String, val publisher: String, val pubdate: String, val cover: String, val author: String)
}
