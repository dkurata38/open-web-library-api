package com.github.dkurata38.open_web_library.domain.book

import com.github.dkurata38.library.domain_lib.persistence.IdIssuer
import com.github.dkurata38.library.domain_lib.persistence.Identifier

data class BookId(val _value: String): Identifier<BookId> {
	companion object {
		private val idIssuer = IdIssuer {
			BookId(it);
		}

		fun issue(): BookId {
			return idIssuer.issue();
		}
	}
	override fun getType(): Class<BookId> {
		return javaClass
	}

	override fun getValue(): String {
		return _value
	}
}
