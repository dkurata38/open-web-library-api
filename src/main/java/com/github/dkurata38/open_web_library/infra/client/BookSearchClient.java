package com.github.dkurata38.open_web_library.infra.client;

import com.github.dkurata38.open_web_library.domain.book.ISBN;

public interface BookSearchClient {
	String getByISBN(ISBN isbn);
}
