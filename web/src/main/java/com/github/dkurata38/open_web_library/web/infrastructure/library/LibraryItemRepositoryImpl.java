package com.github.dkurata38.open_web_library.web.infrastructure.library;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItem;
import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItemId;
import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItemRepository;
import com.github.dkurata38.open_web_library.library_domain.Book;
import com.github.dkurata38.open_web_library.library_domain.BookId;
import com.github.dkurata38.open_web_library.library_domain.BookRepository;
import com.github.dkurata38.open_web_library.library_domain.LibraryItem;
import com.github.dkurata38.open_web_library.library_domain.LibraryItemId;
import com.github.dkurata38.open_web_library.library_domain.LibraryItemRepository;
import com.github.dkurata38.open_web_library.library_domain.OwnerId;

@Repository
public class LibraryItemRepositoryImpl implements LibraryItemRepository {
	private final AddedLibraryItemRepository addedLibraryItemRepository;
	private final BookRepository bookRepository;

	public LibraryItemRepositoryImpl(AddedLibraryItemRepository addedLibraryItemRepository, BookRepository bookRepository) {
		this.addedLibraryItemRepository = addedLibraryItemRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public List<LibraryItem> findByOwnerId(OwnerId ownerId){
		List<AddedLibraryItem> addedLibraryItems = addedLibraryItemRepository.findByOwnerId(ownerId);
		List<BookId> bookIds = addedLibraryItems
				.stream()
				.map(AddedLibraryItem::getBookId)
				.collect(Collectors.toList());
		List<Book> books = bookRepository.findByIds(bookIds);
		Map<BookId, Book> bookMap = books
				.stream()
				.collect(Collectors.toMap(Book::getId, Function.identity()));
		return addedLibraryItems
				.stream()
				.map(addedLibraryItem -> new LibraryItem(new LibraryItemId(addedLibraryItem.getId().getValue()), addedLibraryItem.getBookId(), addedLibraryItem.getOwnerId(), bookMap.get(addedLibraryItem.getBookId()).getBookCollation()))
				.collect(Collectors.toList());
	}

	@Override
	public LibraryItem findById(LibraryItemId id) {
		AddedLibraryItemId addedLibraryItemId = new AddedLibraryItemId(id.getValue());
		AddedLibraryItem addedLibraryItem = addedLibraryItemRepository.findById(addedLibraryItemId);
		if (addedLibraryItem == null) {
			return null;
		}
		Book book = bookRepository.findById(addedLibraryItem.getBookId());
		if (book == null) {
			return null;
		}
		return new LibraryItem(id, addedLibraryItem.getBookId(), addedLibraryItem.getOwnerId(), book.getBookCollation());
	}
}
