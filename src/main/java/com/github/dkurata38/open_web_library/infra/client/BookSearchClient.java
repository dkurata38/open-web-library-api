package com.github.dkurata38.open_web_library.infra.client;

import com.github.dkurata38.open_web_library.domain.book.BookSummary;
import com.github.dkurata38.open_web_library.domain.book.ISBN;

import java.util.Optional;

public interface BookSearchClient {
	Optional<BookSummary> getByISBN(ISBN isbn);
}
