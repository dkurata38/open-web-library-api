package com.github.dkurata38.open_web_library.domain.book

import java.time.LocalDate

data class BookSummary(
		val isbn: ISBN,
		val title: String,
		val author: String,
		val publisher: String,
		val publishedDate: LocalDate,
		val coverImageUrl: String
)
