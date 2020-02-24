package com.github.dkurata38.open_web_library.domain.book

class ISBN(val value: String) {
	companion object {
		fun of(value: String): ISBN {
			if (Type.ISBN13.matches(value)) {
				return Type.ISBN13.toISBN(value)
			}
			if (Type.ISBN10.matches(value)) {
				return Type.ISBN10.toISBN(value)
			}
			throw IllegalArgumentException()
		}

		fun extractFromText(value: String): ISBN {
			if (Type.ISBN13.contains(value)) {
				return Type.ISBN13.toISBNFrom(value)
			}
			if (Type.ISBN10.contains(value)) {
				return Type.ISBN10.toISBNFrom(value)
			}
			throw IllegalArgumentException()
		}
	}

	enum class Type(private val pattern: String) {
		ISBN10("""([\d|\-]{13})""")
		,
		ISBN13("""([\d|\-]{17})""");

		fun matches(testText: String): Boolean {
			return pattern
					.toRegex()
					.matches(testText)
		}

		fun contains(testText: String): Boolean {
			return pattern
					.toRegex()
					.containsMatchIn(testText)
		}

		fun toISBN(source: String): ISBN {
			return pattern
					.toRegex()
					.matchEntire(source)
					?.let { it.groups[1] }
					?.let { ISBN(it.value) }
					?: throw IllegalArgumentException()
		}

		fun toISBNFrom(source: String): ISBN {
			return pattern
					.toRegex()
					.find(source)
					?.let { it.groups[1] }
					?.let { ISBN(it.value) }
					?: throw IllegalArgumentException()
		}
	}
}
