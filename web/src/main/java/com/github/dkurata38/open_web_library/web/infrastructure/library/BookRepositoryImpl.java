package com.github.dkurata38.open_web_library.web.infrastructure.library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.github.dkurata38.open_web_library.library_domain.Book;
import com.github.dkurata38.open_web_library.library_domain.BookId;
import com.github.dkurata38.open_web_library.library_domain.BookRepository;
import com.github.dkurata38.open_web_library.library_domain.Isbn13;

@Repository
class BookRepositoryImpl implements BookRepository {
	private List<Book> values = new ArrayList<>();
	@Override
	public Book findById(BookId id){
		return values
				.stream()
				.filter(e -> e.getId() == id)
				.findFirst()
				.orElse(null);
	}

	@Override
	public List<Book> findByIds(List<BookId> ids) {
		return values
				.stream()
				.filter(e -> ids.contains(e.getId()))
				.collect(Collectors.toList());
	}

	@Override
	public Book findByIsbn(Isbn13 isbn) {
		return values
				.stream()
				.filter(e -> e.getBookCollation().getIsbn13() == isbn)
				.findFirst()
				.orElse(null);
	}

	@Override
	public void insert(Book book) {
		values.add(book);
	}

	@Override
	public void updateById(Book book) {
		values.replaceAll(e -> {
			if (e.getId() == book.getId()) {
				return e.copy(e.getId(), book.getBookCollation());
			}
			return e;
		});
	}
}
