package com.github.dkurata38.open_web_library.library_domain

import com.github.dkurata38.open_web_library.library_domain.LibraryItem

interface GetLibraryItemUseCase {
	/**
	 * @param ownerId 所有者
	 * @return 蔵書リスト
	 */
	fun getByOwnerId(ownerId: String): List<LibraryItem>

	/**
	 * @param id ID
	 * @return 指定したIDの蔵書がなかったら、Nullを返却する
	 */
	fun getById(id: String): LibraryItem?
}
