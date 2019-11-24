package com.github.dkurata38.open_web_library.application.book;

import com.github.dkurata38.open_web_library.domain.book.Book;

import java.util.List;

public interface BookRepository {
	List<Book> findBy();
}
