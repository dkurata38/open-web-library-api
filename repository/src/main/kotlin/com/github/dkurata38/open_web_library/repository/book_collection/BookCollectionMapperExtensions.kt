/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.github.dkurata38.open_web_library.repository.book_collection

import com.github.dkurata38.open_web_library.repository.book_collection.BookCollectionDynamicSqlSupport.BookCollection
import com.github.dkurata38.open_web_library.repository.book_collection.BookCollectionDynamicSqlSupport.BookCollection.bookCollectionId
import com.github.dkurata38.open_web_library.repository.book_collection.BookCollectionDynamicSqlSupport.BookCollection.bookId
import com.github.dkurata38.open_web_library.repository.book_collection.BookCollectionDynamicSqlSupport.BookCollection.libraryId
import com.github.dkurata38.open_web_library.repository.book_collection.BookCollectionRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun BookCollectionMapper.count(completer: CountCompleter) =
		countFrom(this::count, BookCollection, completer)

fun BookCollectionMapper.delete(completer: DeleteCompleter) =
		deleteFrom(this::delete, BookCollection, completer)

fun BookCollectionMapper.deleteByPrimaryKey(bookCollectionId_: String) =
		delete {
			where(bookCollectionId, isEqualTo(bookCollectionId_))
		}

fun BookCollectionMapper.insert(record: BookCollectionRecord) =
		insert(this::insert, record, BookCollection) {
			map(bookCollectionId).toProperty("bookCollectionId")
			map(libraryId).toProperty("libraryId")
			map(bookId).toProperty("bookId")
		}

fun BookCollectionMapper.insertMultiple(records: Collection<BookCollectionRecord>) =
		insertMultiple(this::insertMultiple, records, BookCollection) {
			map(bookCollectionId).toProperty("bookCollectionId")
			map(libraryId).toProperty("libraryId")
			map(bookId).toProperty("bookId")
		}

fun BookCollectionMapper.insertMultiple(vararg records: BookCollectionRecord) =
		insertMultiple(records.toList())

fun BookCollectionMapper.insertSelective(record: BookCollectionRecord) =
		insert(this::insert, record, BookCollection) {
			map(bookCollectionId).toPropertyWhenPresent("bookCollectionId", record::bookCollectionId)
			map(libraryId).toPropertyWhenPresent("libraryId", record::libraryId)
			map(bookId).toPropertyWhenPresent("bookId", record::bookId)
		}

private val columnList = listOf(bookCollectionId, libraryId, bookId)

fun BookCollectionMapper.selectOne(completer: SelectCompleter) =
		selectOne(this::selectOne, columnList, BookCollection, completer)

fun BookCollectionMapper.select(completer: SelectCompleter) =
		selectList(this::selectMany, columnList, BookCollection, completer)

fun BookCollectionMapper.selectDistinct(completer: SelectCompleter) =
		selectDistinct(this::selectMany, columnList, BookCollection, completer)

fun BookCollectionMapper.selectByPrimaryKey(bookCollectionId_: String) =
		selectOne {
			where(bookCollectionId, isEqualTo(bookCollectionId_))
		}

fun BookCollectionMapper.update(completer: UpdateCompleter) =
		update(this::update, BookCollection, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: BookCollectionRecord) =
		apply {
			set(bookCollectionId).equalTo(record::bookCollectionId)
			set(libraryId).equalTo(record::libraryId)
			set(bookId).equalTo(record::bookId)
		}

fun KotlinUpdateBuilder.updateSelectiveColumns(record: BookCollectionRecord) =
		apply {
			set(bookCollectionId).equalToWhenPresent(record::bookCollectionId)
			set(libraryId).equalToWhenPresent(record::libraryId)
			set(bookId).equalToWhenPresent(record::bookId)
		}

fun BookCollectionMapper.updateByPrimaryKey(record: BookCollectionRecord) =
		update {
			set(libraryId).equalTo(record::libraryId)
			set(bookId).equalTo(record::bookId)
			where(bookCollectionId, isEqualTo(record::bookCollectionId))
		}

fun BookCollectionMapper.updateByPrimaryKeySelective(record: BookCollectionRecord) =
		update {
			set(libraryId).equalToWhenPresent(record::libraryId)
			set(bookId).equalToWhenPresent(record::bookId)
			where(bookCollectionId, isEqualTo(record::bookCollectionId))
		}
