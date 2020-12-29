package com.github.dkurata38.open_web_library.library_infra

import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItemRepository
import com.github.dkurata38.open_web_library.library_domain.BookRepository
import com.github.dkurata38.open_web_library.library_domain.LibraryItemRepository
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Configuration
@ComponentScan(basePackages = ["com.github.dkurata38.open_web_library.library_infra"])
class LibraryInfraModule {
	@Bean
	fun addedLibraryItemRepository(): AddedLibraryItemRepository {
		return AddedLibraryItemRepositoryImpl()
	}

	@Bean
	fun bookRepositoryImpl(): BookRepositoryImpl {
		return BookRepositoryImpl()
	}

	@Bean
	fun bookRepository(bookRepositoryImpl: BookRepositoryImpl): BookRepository {
		return bookRepositoryImpl
	}

	@Bean
	fun libraryItemRepository(addedLibraryItemRepository: AddedLibraryItemRepository, bookRepositoryImpl: BookRepositoryImpl): LibraryItemRepository {
		return LibraryItemRepositoryImpl(addedLibraryItemRepository, bookRepositoryImpl)
	}
}
