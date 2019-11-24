package com.github.dkurata38.open_web_library.infra.repository;

import com.github.dkurata38.open_web_library.application.book.BookRepository;
import com.github.dkurata38.open_web_library.domain.book.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

	@Override
	public List<Book> findBy() {
		return null;
	}
}
