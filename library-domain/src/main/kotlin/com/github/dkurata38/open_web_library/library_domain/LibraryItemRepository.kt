package com.github.dkurata38.open_web_library.library_domain

interface LibraryItemRepository {
	fun findByOwnerId(ownerId: OwnerId): List<LibraryItem>
	fun findById(id: LibraryItemId): LibraryItem?
}
