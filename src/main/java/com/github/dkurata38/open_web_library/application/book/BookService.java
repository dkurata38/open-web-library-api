package com.github.dkurata38.open_web_library.application.book;

import com.github.dkurata38.open_web_library.domain.book.Book;
import com.github.dkurata38.open_web_library.domain.book.BookSummary;
import com.github.dkurata38.open_web_library.domain.book.ISBN;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
	private final BookRepository bookRepository;
	private final ImageCognitionClient imageCognitionClient;
	private final BookSearchClient bookSearchClient;

	public List<Book> findBy() {
		// TODO

		return new ArrayList<>();
	}
	public Optional<BookSummary> findByImage(@NonNull Resource resource) {
		return extractISBNFromImage(resource)
		.flatMap(bookSearchClient::getByISBN);
	}

	public Optional<ISBN> extractISBNFromImage(@Nonnull Resource resource) {
		String text = imageCognitionClient.extractTextFromImage(resource);
		try {
			return Optional.of(ISBN.extractBarcodeFromText(text));
		} catch (IllegalArgumentException e) {
			return Optional.empty();
		}
	}
}
