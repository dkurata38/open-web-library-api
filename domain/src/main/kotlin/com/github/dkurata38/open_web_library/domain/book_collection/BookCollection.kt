package com.github.dkurata38.open_web_library.domain.book_collection

import com.github.dkurata38.open_web_library.domain.book.BookId
import com.github.dkurata38.open_web_library.domain.member.MemberId

class BookCollection(val bookCollectionId: BookCollectionId, val memberId: MemberId, val bookId: BookId) {
	companion object {
		fun createInstance(memberId: MemberId, bookId: BookId): BookCollection {
			return BookCollection(BookCollectionId.issue(), memberId, bookId)
		}
	}
}
