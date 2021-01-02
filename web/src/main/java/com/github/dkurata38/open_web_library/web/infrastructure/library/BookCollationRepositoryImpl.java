package com.github.dkurata38.open_web_library.web.infrastructure.library;

import com.github.dkurata38.open_web_library.library_domain.BookCollation;
import com.github.dkurata38.open_web_library.library_domain.BookCollationRepository;
import com.github.dkurata38.open_web_library.library_domain.Isbn13;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestOperations;
import java.time.LocalDate;
import java.util.List;

@Repository
public class BookCollationRepositoryImpl implements BookCollationRepository {

	private final RestOperations restOperations;
	private final GoogleBookProperties googleBookProperties;

	public BookCollationRepositoryImpl(RestOperations restOperations, GoogleBookProperties googleBookProperties) {
		this.restOperations = restOperations;
		this.googleBookProperties = googleBookProperties;
	}

	@Override
	public BookCollation findByIsbn(String isbn) {
		String hyphenLessIsbn = isbn.replace("-", "");
		String format = "https://www.googleapis.com/books/v1/volumes?q=isbn:%s&key=%s";
		Response response = restOperations.getForObject(String.format(format, hyphenLessIsbn, googleBookProperties.getApiKey()), Response.class);
		if (response == null) {
			return null;
		}
		return toBookCollation(isbn, response);
	}

	private BookCollation toBookCollation(String isbn, Response response) {
		if (response.getTotalItems() == 0) {
			return null;
		}
		VolumeInfo volumeInfo = response.getItems().get(0).getVolumeInfo();
		return new BookCollation(volumeInfo.getTitle(), volumeInfo.getAuthors().get(0), volumeInfo.getPublisher(), volumeInfo.getPublishedDate(), volumeInfo.getLanguage(), new Isbn13(isbn));
	}
}

class Response {
	private final List<Item> items;
	private final Integer totalItems;

	public Response(List<Item> items, Integer totalItems) {
		this.items = items;
		this.totalItems = totalItems;
	}

	public List<Item> getItems() {
		return items;
	}

	public Integer getTotalItems() {
		return totalItems;
	}
}

class Item {
	private final VolumeInfo volumeInfo;

	public Item(VolumeInfo volumeInfo) {
		this.volumeInfo = volumeInfo;
	}

	public VolumeInfo getVolumeInfo() {
		return volumeInfo;
	}
}

class VolumeInfo {
	private final String title;
	private final String subtitle;
	private final List<String> authors;
	private final String publisher;
	private final LocalDate publishedDate;
	private final String language;
	private final List<IndustryIdentifier> industryIdentifiers;

	public VolumeInfo(String title, String subtitle, List<String> authors, String publisher, LocalDate publishedDate, String language, List<IndustryIdentifier> industryIdentifiers) {
		this.title = title;
		this.subtitle = subtitle;
		this.authors = authors;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.language = language;
		this.industryIdentifiers = industryIdentifiers;
	}

	public String getTitle() {
		return title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public String getLanguage() {
		return language;
	}

	public List<IndustryIdentifier> getIndustryIdentifiers() {
		return industryIdentifiers;
	}
}

class IndustryIdentifier {
	private final String type;
	private final String identifier;

	public IndustryIdentifier(String type, String identifier) {
		this.type = type;
		this.identifier = identifier;
	}

	public String getType() {
		return type;
	}

	public String getIdentifier() {
		return identifier;
	}
}


