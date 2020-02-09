package com.github.dkurata38.open_web_library.web.book;

import com.github.dkurata38.open_web_library.application.book.BookService;
import com.github.dkurata38.open_web_library.domain.book.Book;
import com.github.dkurata38.open_web_library.domain.book.BookSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequiredArgsConstructor
class BookController {
    private static final String resourcesPath = "books";
    private static final String resourcePath = "book/{id}";

    private final BookService bookService;

//    @PostMapping(resourcesPath + "/search")
//    public Iterable<Book> search() {
//		return bookService.findBy();
//    }

    @PostMapping(resourcesPath + "/image_search")
    public BookSummary searchByImage(@RequestParam MultipartFile image) {
    	return bookService.findByImage(image.getResource())
				.orElse(null);
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
