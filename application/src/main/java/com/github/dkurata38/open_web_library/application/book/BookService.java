package com.github.dkurata38.open_web_library.application.book;

import com.github.dkurata38.open_web_library.domain.book.BookSummary;
import com.github.dkurata38.open_web_library.domain.book.ISBN;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
	private final BookRepository bookRepository;
	private final ImageCognitionClient imageCognitionClient;
	private final BookSearchClient bookSearchClient;

//	public Iterable<Book> findBy() {
//		return bookRepository.findAll();
//	}

	public Optional<BookSummary> findByImage(Resource resource) {
		return extractISBNFromImage(resource)
		.flatMap(bookSearchClient::getByISBN);
	}

	public Optional<ISBN> extractISBNFromImage(Resource resource) {
		String text = imageCognitionClient.extractTextFromImage(resource);
		try {
			return Optional.of(ISBN.extractBarcodeFromText(text));
		} catch (IllegalArgumentException e) {
			return Optional.empty();
		}
	}
}
