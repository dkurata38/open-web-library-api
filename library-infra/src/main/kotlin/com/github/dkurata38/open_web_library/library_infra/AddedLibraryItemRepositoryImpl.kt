package com.github.dkurata38.open_web_library.library_infra

import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItem
import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItemId
import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItemRepository
import com.github.dkurata38.open_web_library.library_domain.OwnerId

class AddedLibraryItemRepositoryImpl: AddedLibraryItemRepository {
	private val values: MutableList<AddedLibraryItem> = mutableListOf()
	override fun findById(id: AddedLibraryItemId): AddedLibraryItem? {
		return values
				.find { e -> e.id == id }
	}

	override fun findByOwnerId(ownerId: OwnerId): List<AddedLibraryItem> {
		return values
				.filter { e -> e.ownerId == ownerId }
	}

	override fun save(addedLibraryItem: AddedLibraryItem) {
		values.add(addedLibraryItem)
	}
}
