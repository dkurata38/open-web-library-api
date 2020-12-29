package com.github.dkurata38.open_web_library.google_books

import com.github.dkurata38.open_web_library.library_domain.BookCollationRepository
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(GoogleBookProperties::class)
class GoogleBookCollationClientModule {
	@Bean
	fun bookCollationRepository(googleBookProperties: GoogleBookProperties): BookCollationRepository {
		val restOperations = RestTemplateBuilder()
				.rootUri("https://www.googleapis.com/books/v1/")
				.build()
		return GoogleBookCollationRepository(restOperations, googleBookProperties)
	}
}
