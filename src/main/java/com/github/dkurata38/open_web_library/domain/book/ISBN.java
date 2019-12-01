package com.github.dkurata38.open_web_library.domain.book;

import lombok.NonNull;

public interface ISBN {
	String getValue();

	static ISBN of(@NonNull String value) {
		if (ISBN10.matches(value)) {
			return new ISBN10(value);
		} else if (ISBN13.matches(value)) {
			return new ISBN13(value);
		}
		throw new IllegalArgumentException();
	}

	static ISBN ofBarcode(@NonNull String value) {
		if (ISBN10.matchesWithBarcode(value)) {
			return ISBN10.fromBarcode(value);
		} else if (ISBN13.matchesWithBarcode(value)) {
			return ISBN13.fromBarcode(value);
		}
		throw new IllegalArgumentException();
	}
}
