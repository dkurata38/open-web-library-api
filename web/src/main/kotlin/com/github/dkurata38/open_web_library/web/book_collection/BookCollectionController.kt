package com.github.dkurata38.open_web_library.web.book_collection

import com.github.dkurata38.open_web_library.application.book.BookService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.ModelAndView

@Controller
class BookCollectionController(private val bookService: BookService) {
	companion object {
		private const val resourcesPath = "book_collections"
		private const val resourcePath = "book_collection/{id}"
	}

	@GetMapping(resourcesPath)
	fun index(): ModelAndView {
		return ModelAndView("book_collection/index")
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

	@GetMapping("$resourcesPath/input")
	fun input(): ModelAndView {
		return ModelAndView("book_collection/input")
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
