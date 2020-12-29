package com.github.dkurata38.open_web_library.library_domain

import java.time.LocalDate

interface AddLibraryItemUseCase {

	/**
	 * 指定した書誌情報の書籍を、指定した所有者の蔵書として登録する。
	 * @param title 書籍タイトル
	 * @param authorName 著者名
	 * @param publisherName 出版社名
	 * @param onSaleDate 発売日
	 * @param language 言語
	 * @param isbn ISBN13
	 * @param ownerId 所有者
	 */
	fun add(title: String, authorName: String, publisherName: String, onSaleDate: LocalDate, language: String, isbn: String, ownerId: String)
}
