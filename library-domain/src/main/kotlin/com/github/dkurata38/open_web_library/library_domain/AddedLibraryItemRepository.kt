package com.github.dkurata38.open_web_library.library_domain

interface AddedLibraryItemRepository {
	fun findById(id: AddedLibraryItemId): AddedLibraryItem?
	fun findByOwnerId(ownerId: OwnerId): List<AddedLibraryItem>
	fun save(addedLibraryItem: AddedLibraryItem)
}
