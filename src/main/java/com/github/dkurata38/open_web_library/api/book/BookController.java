package com.github.dkurata38.open_web_library.api.book;

import com.github.dkurata38.open_web_library.application.book.BookService;
import com.github.dkurata38.open_web_library.domain.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
class BookController {
    private static final String resourcesPath = "books";
    private static final String resourcePath = "book/{id}";

    private final BookService bookService;

    @PostMapping(resourcesPath + "/search")
    public List<Book> search() {
		return bookService.findBy();
    }

    @GetMapping(resourcePath)
    public Book show(@PathVariable Integer id) {
    	// TODO
		return null;
    }

    @PostMapping(resourcesPath)
	public Integer create() {
    	// TODO
    	return null;
	}

	@DeleteMapping(resourcePath)
	public void delete(@PathVariable Integer id) {
    	// TODO
	}
}
