package com.github.dkurata38.open_web_library.domain.book;

import lombok.Value;

import java.time.LocalDate;

@Value
public class BookSummary {
	private final ISBN isbn;
	private final String title;
	private final String author;
	private final String publisher;
	private final LocalDate publishedDate;
	private final String coverImageUrl;
}
