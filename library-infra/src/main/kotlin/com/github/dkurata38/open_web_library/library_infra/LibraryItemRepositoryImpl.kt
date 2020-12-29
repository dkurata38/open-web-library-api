package com.github.dkurata38.open_web_library.library_infra

import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItemId
import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItemRepository
import com.github.dkurata38.open_web_library.library_domain.LibraryItem
import com.github.dkurata38.open_web_library.library_domain.LibraryItemId
import com.github.dkurata38.open_web_library.library_domain.LibraryItemRepository
import com.github.dkurata38.open_web_library.library_domain.OwnerId

class LibraryItemRepositoryImpl(private val addedLibraryItemRepository: AddedLibraryItemRepository, private val bookRepository: BookRepositoryImpl): LibraryItemRepository {
	override fun findByOwnerId(ownerId: OwnerId): List<LibraryItem> {
		val addedLibraryItems= addedLibraryItemRepository.findByOwnerId(ownerId)
		val bookIds = addedLibraryItems
				.map { e -> e.bookId }
		val books = bookRepository.findByIds(bookIds)
		val bookMap = books.map { e -> Pair(e.id, e) }.toMap()
		return addedLibraryItems.map {
			LibraryItem(LibraryItemId(it.id.value), it.bookId, it.ownerId, (bookMap[it.bookId] ?: error("")).bookCollation)
		}
	}

	override fun findById(id: LibraryItemId): LibraryItem? {
		val addedLibraryItemId = AddedLibraryItemId(id.value)
		val addedLibraryItem = addedLibraryItemRepository.findById(addedLibraryItemId)
		if (addedLibraryItem == null) {
			return null
		}
		val book = bookRepository.findById(addedLibraryItem.bookId)
		if (book == null) {
			return null;
		}
		return LibraryItem(id, addedLibraryItem.bookId, addedLibraryItem.ownerId, book.bookCollation)
	}
}
