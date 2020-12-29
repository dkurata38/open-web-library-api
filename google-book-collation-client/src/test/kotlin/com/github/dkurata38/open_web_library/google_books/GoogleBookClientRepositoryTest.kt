package com.github.dkurata38.open_web_library.google_books

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [GoogleBookCollationClientModule::class])
internal class GoogleBookClientRepositoryTest(@Autowired private val googleBookClientRepository: GoogleBookCollationRepository) {
	fun testFindByIsbn() {
		fail<Unit>()
	}
}
