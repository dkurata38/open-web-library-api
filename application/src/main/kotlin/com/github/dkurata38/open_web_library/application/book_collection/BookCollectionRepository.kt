package com.github.dkurata38.open_web_library.application.book_collection

import com.github.dkurata38.open_web_library.domain.book_collection.BookCollection

interface BookCollectionRepository {
	fun save(bookCollection: BookCollection)
}
