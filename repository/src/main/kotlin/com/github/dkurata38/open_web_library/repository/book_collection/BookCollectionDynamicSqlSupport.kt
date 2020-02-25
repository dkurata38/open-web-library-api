/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.github.dkurata38.open_web_library.repository.book_collection

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object BookCollectionDynamicSqlSupport {
	object BookCollection : SqlTable("book_collection") {
		val bookCollectionId = column<String>("book_collection_id", JDBCType.VARCHAR)

		val libraryId = column<String>("library_id", JDBCType.VARCHAR)

		val bookId = column<String>("book_id", JDBCType.VARCHAR)
	}
}
