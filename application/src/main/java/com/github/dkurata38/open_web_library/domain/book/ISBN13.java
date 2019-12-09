package com.github.dkurata38.open_web_library.domain.book;

import lombok.NonNull;
import lombok.Value;

import javax.annotation.Nonnull;
import java.util.regex.Pattern;

@Value
class ISBN13 implements ISBN {
	private final static String PATTERN_STRING = "[\\d|\\-]{17}";
	final static Pattern PATTERN = Pattern.compile(PATTERN_STRING);
	private final static String BARCODE_PATTERN_STRING = "ISBN" + PATTERN_STRING;
	final static Pattern BARCODE_PATTERN = Pattern.compile(BARCODE_PATTERN_STRING);

	@org.hibernate.validator.constraints.ISBN
	private final String value;

	static ISBN10 fromBarcode(@Nonnull String text) {
		if (!matchesWithBarcode(text)) {
			throw new IllegalArgumentException();
		}
		return new ISBN10(text.replace("ISBN", ""));
	}

	static Boolean matches(@NonNull String testText) {
		return PATTERN.matcher(testText).matches();
	}

	static Boolean matchesWithBarcode(@NonNull String testText) {
		return BARCODE_PATTERN.matcher(testText).matches();
	}
}