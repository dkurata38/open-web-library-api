package com.github.dkurata38.open_web_library.domain.book;

import lombok.NonNull;

import java.util.regex.Matcher;

public interface ISBN {
	String getValue();

	static ISBN of(@NonNull String value) {
		if (ISBN13.matches(value)) {
			return new ISBN13(value);
		}
		if (ISBN10.matches(value)) {
			return new ISBN10(value);
		}
		throw new IllegalArgumentException();
	}

	static ISBN ofBarcode(@NonNull String value) {
		if (ISBN13.matchesWithBarcode(value)) {
			return ISBN13.fromBarcode(value);
		}
		if (ISBN10.matchesWithBarcode(value)) {
			return ISBN10.fromBarcode(value);
		}
		throw new IllegalArgumentException();
	}

	static ISBN extractBarcodeFromText(String value) {
		Matcher isbn13Matcher = ISBN13.BARCODE_PATTERN.matcher(value);
		if (isbn13Matcher.find()) {
			return ISBN13.fromBarcode(isbn13Matcher.group());
		}
		Matcher isbn10Matcher = ISBN10.BARCODE_PATTERN.matcher(value);
		if (isbn10Matcher.find()) {
			return ISBN10.fromBarcode(isbn10Matcher.group());
		}
		throw new IllegalArgumentException();
	}
}
