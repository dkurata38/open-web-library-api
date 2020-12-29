package com.github.dkurata38.open_web_library.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import com.github.dkurata38.open_web_library.google_books.GoogleBookCollationClientModule;
import com.github.dkurata38.open_web_library.library_domain.AddLibraryItemUseCase;
import com.github.dkurata38.open_web_library.library_domain.AddLibraryItemUseCaseImpl;
import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItemRepository;
import com.github.dkurata38.open_web_library.library_domain.BookRepository;
import com.github.dkurata38.open_web_library.library_domain.GetLibraryItemUseCase;
import com.github.dkurata38.open_web_library.library_domain.GetLibraryItemUseCaseImpl;
import com.github.dkurata38.open_web_library.library_domain.LibraryItemRepository;
import com.github.dkurata38.open_web_library.library_infra.LibraryInfraModule;

@SpringBootApplication
@Import({GoogleBookCollationClientModule.class, LibraryInfraModule.class})
public class OpenWebLibraryWebApplication {

	@Bean
	public AddLibraryItemUseCase addLibraryItemUseCase(AddedLibraryItemRepository addedLibraryItemRepository, BookRepository bookRepository) {
		return new AddLibraryItemUseCaseImpl(addedLibraryItemRepository, bookRepository);
	}

	@Bean
	public GetLibraryItemUseCase getLibraryItemUseCase(LibraryItemRepository libraryItemRepository) {
		return new GetLibraryItemUseCaseImpl(libraryItemRepository);
	}

	public static void main(String[] args) {
		SpringApplication.run(OpenWebLibraryWebApplication.class, args);
	}
}
