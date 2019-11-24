package com.github.dkurata38.open_web_library.application.book;

import com.github.dkurata38.open_web_library.domain.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
	private final BookRepository bookRepository;

	public List<Book> findBy() {
		// TODO
		return new ArrayList<>();
	}
}
