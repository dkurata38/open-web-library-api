package com.github.dkurata38.open_web_library.web.library;

import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.format.annotation.DateTimeFormat;

public class AddLibraryItemForm {
	@NotEmpty
	private String title;
	@NotEmpty
	private String authorName;
	@NotEmpty
	private String publisherName;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate onSaleDate;
	@NotEmpty
	private String language;
	@ISBN(type = ISBN.Type.ISBN_13)
	private String isbn;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public LocalDate getOnSaleDate() {
		return onSaleDate;
	}

	public void setOnSaleDate(LocalDate onSaleDate) {
		this.onSaleDate = onSaleDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
