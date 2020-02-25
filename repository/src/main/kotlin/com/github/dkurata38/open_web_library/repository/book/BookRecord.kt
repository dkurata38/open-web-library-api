/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.github.dkurata38.open_web_library.repository.book

import java.time.LocalDate

data class BookRecord(
		val bookId: String,
		val title: String,
		val author: String,
		val formatType: String,
		val coverImageUrl: String,
		val description: String,
		val publisher: String,
		var publishedDate: LocalDate? = null,
		val language: String,
		val pageCount: Int,
		val isbn: String
)
