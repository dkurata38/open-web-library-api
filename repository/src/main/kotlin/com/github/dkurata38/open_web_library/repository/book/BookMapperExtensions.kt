/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.github.dkurata38.open_web_library.repository.book

import com.github.dkurata38.open_web_library.repository.book.BookDynamicSqlSupport.Book
import com.github.dkurata38.open_web_library.repository.book.BookDynamicSqlSupport.Book.author
import com.github.dkurata38.open_web_library.repository.book.BookDynamicSqlSupport.Book.bookId
import com.github.dkurata38.open_web_library.repository.book.BookDynamicSqlSupport.Book.coverImageUrl
import com.github.dkurata38.open_web_library.repository.book.BookDynamicSqlSupport.Book.description
import com.github.dkurata38.open_web_library.repository.book.BookDynamicSqlSupport.Book.formatType
import com.github.dkurata38.open_web_library.repository.book.BookDynamicSqlSupport.Book.isbn
import com.github.dkurata38.open_web_library.repository.book.BookDynamicSqlSupport.Book.language
import com.github.dkurata38.open_web_library.repository.book.BookDynamicSqlSupport.Book.pageCount
import com.github.dkurata38.open_web_library.repository.book.BookDynamicSqlSupport.Book.publishedDate
import com.github.dkurata38.open_web_library.repository.book.BookDynamicSqlSupport.Book.publisher
import com.github.dkurata38.open_web_library.repository.book.BookDynamicSqlSupport.Book.title
import com.github.dkurata38.open_web_library.repository.book.BookRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun BookMapper.count(completer: CountCompleter) =
		countFrom(this::count, Book, completer)

fun BookMapper.delete(completer: DeleteCompleter) =
		deleteFrom(this::delete, Book, completer)

fun BookMapper.deleteByPrimaryKey(bookId_: String) =
		delete {
			where(bookId, isEqualTo(bookId_))
		}

fun BookMapper.insert(record: BookRecord) =
		insert(this::insert, record, Book) {
			map(bookId).toProperty("bookId")
			map(title).toProperty("title")
			map(author).toProperty("author")
			map(formatType).toProperty("formatType")
			map(coverImageUrl).toProperty("coverImageUrl")
			map(description).toProperty("description")
			map(publisher).toProperty("publisher")
			map(publishedDate).toProperty("publishedDate")
			map(language).toProperty("language")
			map(pageCount).toProperty("pageCount")
			map(isbn).toProperty("isbn")
		}

fun BookMapper.insertMultiple(records: Collection<BookRecord>) =
		insertMultiple(this::insertMultiple, records, Book) {
			map(bookId).toProperty("bookId")
			map(title).toProperty("title")
			map(author).toProperty("author")
			map(formatType).toProperty("formatType")
			map(coverImageUrl).toProperty("coverImageUrl")
			map(description).toProperty("description")
			map(publisher).toProperty("publisher")
			map(publishedDate).toProperty("publishedDate")
			map(language).toProperty("language")
			map(pageCount).toProperty("pageCount")
			map(isbn).toProperty("isbn")
		}

fun BookMapper.insertMultiple(vararg records: BookRecord) =
		insertMultiple(records.toList())

fun BookMapper.insertSelective(record: BookRecord) =
		insert(this::insert, record, Book) {
			map(bookId).toPropertyWhenPresent("bookId", record::bookId)
			map(title).toPropertyWhenPresent("title", record::title)
			map(author).toPropertyWhenPresent("author", record::author)
			map(formatType).toPropertyWhenPresent("formatType", record::formatType)
			map(coverImageUrl).toPropertyWhenPresent("coverImageUrl", record::coverImageUrl)
			map(description).toPropertyWhenPresent("description", record::description)
			map(publisher).toPropertyWhenPresent("publisher", record::publisher)
			map(publishedDate).toPropertyWhenPresent("publishedDate", record::publishedDate)
			map(language).toPropertyWhenPresent("language", record::language)
			map(pageCount).toPropertyWhenPresent("pageCount", record::pageCount)
			map(isbn).toPropertyWhenPresent("isbn", record::isbn)
		}

private val columnList = listOf(bookId, title, author, formatType, coverImageUrl, description, publisher, publishedDate, language, pageCount, isbn)

fun BookMapper.selectOne(completer: SelectCompleter) =
		selectOne(this::selectOne, columnList, Book, completer)

fun BookMapper.select(completer: SelectCompleter) =
		selectList(this::selectMany, columnList, Book, completer)

fun BookMapper.selectDistinct(completer: SelectCompleter) =
		selectDistinct(this::selectMany, columnList, Book, completer)

fun BookMapper.selectByPrimaryKey(bookId_: String) =
		selectOne {
			where(bookId, isEqualTo(bookId_))
		}

fun BookMapper.update(completer: UpdateCompleter) =
		update(this::update, Book, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: BookRecord) =
		apply {
			set(bookId).equalTo(record::bookId)
			set(title).equalTo(record::title)
			set(author).equalTo(record::author)
			set(formatType).equalTo(record::formatType)
			set(coverImageUrl).equalTo(record::coverImageUrl)
			set(description).equalTo(record::description)
			set(publisher).equalTo(record::publisher)
			set(publishedDate).equalTo(record::publishedDate)
			set(language).equalTo(record::language)
			set(pageCount).equalTo(record::pageCount)
			set(isbn).equalTo(record::isbn)
		}

fun KotlinUpdateBuilder.updateSelectiveColumns(record: BookRecord) =
		apply {
			set(bookId).equalToWhenPresent(record::bookId)
			set(title).equalToWhenPresent(record::title)
			set(author).equalToWhenPresent(record::author)
			set(formatType).equalToWhenPresent(record::formatType)
			set(coverImageUrl).equalToWhenPresent(record::coverImageUrl)
			set(description).equalToWhenPresent(record::description)
			set(publisher).equalToWhenPresent(record::publisher)
			set(publishedDate).equalToWhenPresent(record::publishedDate)
			set(language).equalToWhenPresent(record::language)
			set(pageCount).equalToWhenPresent(record::pageCount)
			set(isbn).equalToWhenPresent(record::isbn)
		}

fun BookMapper.updateByPrimaryKey(record: BookRecord) =
		update {
			set(title).equalTo(record::title)
			set(author).equalTo(record::author)
			set(formatType).equalTo(record::formatType)
			set(coverImageUrl).equalTo(record::coverImageUrl)
			set(description).equalTo(record::description)
			set(publisher).equalTo(record::publisher)
			set(publishedDate).equalTo(record::publishedDate)
			set(language).equalTo(record::language)
			set(pageCount).equalTo(record::pageCount)
			set(isbn).equalTo(record::isbn)
			where(bookId, isEqualTo(record::bookId))
		}

fun BookMapper.updateByPrimaryKeySelective(record: BookRecord) =
		update {
			set(title).equalToWhenPresent(record::title)
			set(author).equalToWhenPresent(record::author)
			set(formatType).equalToWhenPresent(record::formatType)
			set(coverImageUrl).equalToWhenPresent(record::coverImageUrl)
			set(description).equalToWhenPresent(record::description)
			set(publisher).equalToWhenPresent(record::publisher)
			set(publishedDate).equalToWhenPresent(record::publishedDate)
			set(language).equalToWhenPresent(record::language)
			set(pageCount).equalToWhenPresent(record::pageCount)
			set(isbn).equalToWhenPresent(record::isbn)
			where(bookId, isEqualTo(record::bookId))
		}
