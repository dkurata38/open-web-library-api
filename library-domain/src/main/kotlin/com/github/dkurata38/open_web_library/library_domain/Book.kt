package com.github.dkurata38.open_web_library.library_domain

import java.time.LocalDate

data class Book(val id: BookId, val bookCollation: BookCollation)

data class BookCollation(val title: String, val authorName: String, val publisherName: String,
						 val publishedOn: LocalDate, val language: String, val isbn13: Isbn13)

data class BookId(val value: String) {
	companion object {
		fun issue(): BookId {
			return BookId(IdIssuer.generateIdValue())
		}
	}
}

data class Isbn13(val value: String) {
	init {
		val isbn13Pattern = """^(978|979)-([0-9\-]{11})-[0-9X]$""".toRegex()
		val matchResult = isbn13Pattern.matchEntire(value)?: throw IllegalArgumentException()
		if (matchResult.groupValues.size < 3) {
			throw IllegalArgumentException()
		}
	}
}
