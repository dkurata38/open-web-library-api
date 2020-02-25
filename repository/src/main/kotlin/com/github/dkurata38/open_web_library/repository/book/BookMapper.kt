/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.github.dkurata38.open_web_library.repository.book

import com.github.dkurata38.open_web_library.repository.book.BookRecord
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
interface BookMapper {
	@SelectProvider(type = SqlProviderAdapter::class, method = "select")
	fun count(selectStatement: SelectStatementProvider): Long

	@DeleteProvider(type = SqlProviderAdapter::class, method = "delete")
	fun delete(deleteStatement: DeleteStatementProvider): Int

	@InsertProvider(type = SqlProviderAdapter::class, method = "insert")
	fun insert(insertStatement: InsertStatementProvider<BookRecord>): Int

	@InsertProvider(type = SqlProviderAdapter::class, method = "insertMultiple")
	fun insertMultiple(multipleInsertStatement: MultiRowInsertStatementProvider<BookRecord>): Int

	@SelectProvider(type = SqlProviderAdapter::class, method = "select")
	@ResultMap("BookRecordResult")
	fun selectOne(selectStatement: SelectStatementProvider): BookRecord?

	@SelectProvider(type = SqlProviderAdapter::class, method = "select")
	@Results(id = "BookRecordResult", value = [
		Result(column = "book_id", property = "bookId", jdbcType = JdbcType.VARCHAR, id = true),
		Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
		Result(column = "author", property = "author", jdbcType = JdbcType.VARCHAR),
		Result(column = "format_type", property = "formatType", jdbcType = JdbcType.VARCHAR),
		Result(column = "cover_image_url", property = "coverImageUrl", jdbcType = JdbcType.VARCHAR),
		Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
		Result(column = "publisher", property = "publisher", jdbcType = JdbcType.VARCHAR),
		Result(column = "published_date", property = "publishedDate", jdbcType = JdbcType.DATE),
		Result(column = "language", property = "language", jdbcType = JdbcType.VARCHAR),
		Result(column = "page_count", property = "pageCount", jdbcType = JdbcType.INTEGER),
		Result(column = "isbn", property = "isbn", jdbcType = JdbcType.VARCHAR)
	])
	fun selectMany(selectStatement: SelectStatementProvider): List<BookRecord>

	@UpdateProvider(type = SqlProviderAdapter::class, method = "update")
	fun update(updateStatement: UpdateStatementProvider): Int
}
