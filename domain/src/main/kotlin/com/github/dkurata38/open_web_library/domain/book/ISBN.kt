package com.github.dkurata38.open_web_library.domain.book

sealed class ISBN(val value: String) {
	companion object {
		fun of(value: String): ISBN {
			if (ISBN13.matches(value)) {
				return ISBN13(value)
			}
			if (ISBN10.matches(value)) {
				return ISBN10(value)
			}
			throw IllegalArgumentException()
		}

		fun ofBarcode(value: String): ISBN {
			if (ISBN13.matchesWithBarcode(value)) {
				return ISBN13.fromBarcode(value)
			}
			if (ISBN10.matchesWithBarcode(value)) {
				return ISBN10.fromBarcode(value)
			}
			throw IllegalArgumentException()
		}

		fun extractBarcodeFromText(value: String): ISBN {
			if (ISBN13.matchesWithBarcode(value)) {
				return ISBN13.fromBarcode(value)
			}
			if (ISBN10.matchesWithBarcode(value)) {
				return ISBN10.fromBarcode(value)
			}
			throw IllegalArgumentException()
		}

		class ISBN10(value: String) : ISBN(value) {
			companion object {
				private const val PATTERN_STRING: String = """([\d|\-]{13})"""
				private const val BARCODE_PATTERN_STRING: String = "ISBN$PATTERN_STRING"

				fun fromBarcode(text: String): ISBN10 {
					return BARCODE_PATTERN_STRING
							.toRegex()
							.find(text)
							?.value
							?.let { ISBN10(it) }
							?: throw java.lang.IllegalArgumentException()
				}

				fun matches(testText: String): Boolean {
					return PATTERN_STRING
							.toRegex()
							.matches(testText)
				}

				fun matchesWithBarcode(testText: String): Boolean {
					return BARCODE_PATTERN_STRING
							.toRegex()
							.matches(testText)
				}
			}
		}

		class ISBN13(value: String) : ISBN(value) {
			companion object {
				private const val PATTERN_STRING = """[\d|\-]{17}"""
				private const val BARCODE_PATTERN_STRING = "ISBN$PATTERN_STRING"
				fun fromBarcode(text: String): ISBN13 {
					return ISBN13(text)
				}

				fun matches(testText: String): Boolean {
					return PATTERN_STRING
							.toRegex()
							.matches(testText)
				}

				fun matchesWithBarcode(testText: String): Boolean {
					return BARCODE_PATTERN_STRING
							.toRegex()
							.matches(testText)
				}
			}
		}
	}
}
