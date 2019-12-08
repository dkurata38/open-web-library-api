package com.github.dkurata38.open_web_library.application.book;

import com.github.dkurata38.open_web_library.domain.book.Book;
import com.github.dkurata38.open_web_library.domain.book.BookId;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, BookId> {
}
