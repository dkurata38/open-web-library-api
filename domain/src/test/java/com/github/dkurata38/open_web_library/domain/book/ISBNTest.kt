package com.github.dkurata38.open_web_library.domain.book

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

internal class ISBNTest {

	@Test
	fun testOfISBN13() {
		val value = "978-4-295-00003-7"
		val isbn = ISBN.of(value)
		assertEquals(value, isbn.value)
	}

	@Test
	fun testOfISBN13Fail() {
		val value = "ISBN978-4-295-00003-7"
		assertThrows(IllegalArgumentException::class.java) { ISBN.of(value) }
	}

	@Test
	fun testOfBarcodeISBN13() {
		val value = "978-4-295-00003-7"
		val test = "ISBN$value"
		val isbn = ISBN.extractFromText(test)
		assertEquals(value, isbn.value)
	}
}
