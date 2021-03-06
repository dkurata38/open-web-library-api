package com.github.dkurata38.open_web_library.web.book

import com.github.dkurata38.open_web_library.application.book.BookService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.ModelAndView

@Controller
class BookCollectionController(private val bookService: BookService) {
	companion object {
		private const val resourcesPath = "books"
		private const val resourcePath = "book/{id}"
	}

//    @PostMapping(resourcesPath + "/search")
//    public Iterable<Book> search() {
//		return bookService.findBy()
//    }

    @PostMapping("$resourcesPath/image_search")
    fun searchByImage(@RequestParam image: MultipartFile): ModelAndView {
		val bookSummary = bookService.findByImage(image.resource)
		val modelAndView = ModelAndView("book_collection/input")
				.addObject("bookSummary", bookSummary)
		return modelAndView
	}

    @GetMapping(resourcePath)
	fun show(@PathVariable id: Int) {
    	// TODO
		return
    }

    @PostMapping(resourcesPath)
	fun create() {
    	// TODO
    	return
	}

	@DeleteMapping(resourcePath)
	fun delete(@PathVariable id: Int) {
    	// TODO
	}
}
