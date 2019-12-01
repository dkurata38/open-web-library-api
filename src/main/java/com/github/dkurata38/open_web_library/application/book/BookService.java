package com.github.dkurata38.open_web_library.application.book;

import com.github.dkurata38.open_web_library.domain.book.*;
import com.github.dkurata38.open_web_library.infra.client.BookSearchClient;
import com.github.dkurata38.open_web_library.infra.client.ImageCognitionClient;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;

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
		ISBN isbn = extractISBNFromImage(resource);
		return bookSearchClient.getByISBN(isbn);
	}

	public ISBN extractISBNFromImage(@Nonnull Resource resource) {
		String text = imageCognitionClient.extractTextFromImage(resource);
		Matcher isbn13Matcher = ISBN13.BARCODE_PATTERN.matcher(text);
		if (isbn13Matcher.find()) {
			return ISBN13.fromBarcode(isbn13Matcher.group());
		}

		Matcher isbn10Matcher = ISBN10.BARCODE_PATTERN.matcher(text);
		if (isbn10Matcher.find()) {
			return ISBN10.fromBarcode(isbn10Matcher.group());
		}
		throw new IllegalArgumentException();
	}
}
