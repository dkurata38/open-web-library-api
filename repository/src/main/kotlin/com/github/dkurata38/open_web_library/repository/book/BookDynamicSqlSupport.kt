/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.github.dkurata38.open_web_library.repository.book

import java.sql.JDBCType
import java.time.LocalDate
import org.mybatis.dynamic.sql.SqlTable

object BookDynamicSqlSupport {
	object Book : SqlTable("book") {
		val bookId = column<String>("book_id", JDBCType.VARCHAR)

		val title = column<String>("title", JDBCType.VARCHAR)

		val author = column<String>("author", JDBCType.VARCHAR)

		val formatType = column<String>("format_type", JDBCType.VARCHAR)

		val coverImageUrl = column<String>("cover_image_url", JDBCType.VARCHAR)

		val description = column<String>("description", JDBCType.VARCHAR)

		val publisher = column<String>("publisher", JDBCType.VARCHAR)

		val publishedDate = column<LocalDate>("published_date", JDBCType.DATE)

		val language = column<String>("language", JDBCType.VARCHAR)

		val pageCount = column<Int>("page_count", JDBCType.INTEGER)

		val isbn = column<String>("isbn", JDBCType.VARCHAR)
	}
}
