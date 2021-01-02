package com.github.dkurata38.open_web_library.library_domain

interface BookCollationRepository {
	fun findByIsbn(isbn: String): BookCollation?
}
