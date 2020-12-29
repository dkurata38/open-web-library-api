package com.github.dkurata38.open_web_library.library_domain

class GetLibraryItemUseCaseImpl(private val libraryItemRepository: LibraryItemRepository) : GetLibraryItemUseCase {
	override fun getByOwnerId(ownerId: String): List<LibraryItem> {
		return libraryItemRepository.findByOwnerId(OwnerId(ownerId))
	}

	override fun getById(id: String): LibraryItem? {
		return libraryItemRepository.findById(LibraryItemId(id))
	}
}
