package com.github.dkurata38.open_web_library.repository.book_collection

import com.github.dkurata38.open_web_library.application.book_collection.BookCollectionRepository
import com.github.dkurata38.open_web_library.domain.book_collection.BookCollection
import org.springframework.stereotype.Repository

@Repository
class BookCollectionRepositoryImpl: BookCollectionRepository {
	override fun save(bookCollection: BookCollection) {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}
}
