package com.github.dkurata38.open_web_library.domain.book_collection

import com.github.dkurata38.library.domain_lib.persistence.IdIssuer
import com.github.dkurata38.library.domain_lib.persistence.Identifier

class BookCollectionId(@get:JvmName("_getValue") val value: String): Identifier<BookCollectionId> {

	companion object: IdIssuer<BookCollectionId>({value ->BookCollectionId(value)})

	override fun getType(): Class<BookCollectionId> {
		return javaClass
	}

	override fun getValue(): String {
		return value;
	}
}
