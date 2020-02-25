/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.github.dkurata38.open_web_library.repository.book_collection

import com.github.dkurata38.open_web_library.repository.book_collection.BookCollectionRecord
import org.apache.ibatis.annotations.DeleteProvider
import org.apache.ibatis.annotations.InsertProvider
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.annotations.UpdateProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter

@Mapper
interface BookCollectionMapper {
	@SelectProvider(type = SqlProviderAdapter::class, method = "select")
	fun count(selectStatement: SelectStatementProvider): Long

	@DeleteProvider(type = SqlProviderAdapter::class, method = "delete")
	fun delete(deleteStatement: DeleteStatementProvider): Int

	@InsertProvider(type = SqlProviderAdapter::class, method = "insert")
	fun insert(insertStatement: InsertStatementProvider<BookCollectionRecord>): Int

	@InsertProvider(type = SqlProviderAdapter::class, method = "insertMultiple")
	fun insertMultiple(multipleInsertStatement: MultiRowInsertStatementProvider<BookCollectionRecord>): Int

	@SelectProvider(type = SqlProviderAdapter::class, method = "select")
	@ResultMap("BookCollectionRecordResult")
	fun selectOne(selectStatement: SelectStatementProvider): BookCollectionRecord?

	@SelectProvider(type = SqlProviderAdapter::class, method = "select")
	@Results(id = "BookCollectionRecordResult", value = [
		Result(column = "book_collection_id", property = "bookCollectionId", jdbcType = JdbcType.VARCHAR, id = true),
		Result(column = "library_id", property = "libraryId", jdbcType = JdbcType.VARCHAR),
		Result(column = "book_id", property = "bookId", jdbcType = JdbcType.VARCHAR)
	])
	fun selectMany(selectStatement: SelectStatementProvider): List<BookCollectionRecord>

	@UpdateProvider(type = SqlProviderAdapter::class, method = "update")
	fun update(updateStatement: UpdateStatementProvider): Int
}
