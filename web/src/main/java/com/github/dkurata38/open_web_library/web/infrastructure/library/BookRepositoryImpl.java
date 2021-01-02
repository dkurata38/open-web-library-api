package com.github.dkurata38.open_web_library.web.infrastructure.library;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.github.dkurata38.open_web_library.library_domain.Book;
import com.github.dkurata38.open_web_library.library_domain.BookId;
import com.github.dkurata38.open_web_library.library_domain.BookRepository;
import com.github.dkurata38.open_web_library.library_domain.Isbn13;

@Repository
class BookRepositoryImpl implements BookRepository {
	private final BookMapper bookMapper;

	public BookRepositoryImpl(BookMapper bookMapper) {
		this.bookMapper = bookMapper;
	}

	@Override
	public Book findById(BookId id){
		return bookMapper.selectById(id);
	}

	@Override
	public List<Book> findByIds(List<BookId> ids) {
		return bookMapper.selectAllBy(ids);
	}

	@Override
	public Book findByIsbn(Isbn13 isbn) {
		return bookMapper.selectByIsbn13(isbn);
	}

	@Override
	public void insert(Book book) {
		bookMapper.insert(book);
	}

	@Override
	public void updateById(Book book) {
		bookMapper.updateById(book);
	}
}
