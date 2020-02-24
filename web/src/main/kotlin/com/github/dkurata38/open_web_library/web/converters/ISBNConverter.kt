package com.github.dkurata38.open_web_library.web.converters

import com.github.dkurata38.open_web_library.domain.book.ISBN
import org.springframework.core.convert.converter.Converter

class ISBNConverter : Converter<String, ISBN> {
	override fun convert(source: String): ISBN? {
		return runCatching { ISBN.of(source) }
				.getOrNull()
	}
}
