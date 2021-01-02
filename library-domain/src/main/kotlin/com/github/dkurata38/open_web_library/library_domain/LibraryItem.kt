package com.github.dkurata38.open_web_library.library_domain

import java.time.LocalDateTime

data class AddedLibraryItem(val id: AddedLibraryItemId, val bookId: BookId, val ownerId: OwnerId, val addedAt: LocalDateTime)

data class AddedLibraryItemId(val value: String) {
	companion object {
		fun issue(): AddedLibraryItemId {
			return AddedLibraryItemId(IdIssuer.generateIdValue())
		}
	}
}

data class OwnerId(val value: String)

data class LibraryItem(val id: LibraryItemId, val bookId: BookId, val ownerId: OwnerId, val bookCollation: BookCollation)

data class LibraryItemId(val value: String)
