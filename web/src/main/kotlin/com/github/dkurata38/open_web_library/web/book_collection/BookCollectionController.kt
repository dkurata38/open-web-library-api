package com.github.dkurata38.open_web_library.web.book_collection

import com.github.dkurata38.open_web_library.application.book.BookService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.servlet.view.RedirectView

@Controller
class BookCollectionController(private val bookService: BookService) {
	companion object {
		private const val resourcesPath = "/book_collections"
		private const val resourcePath = "/book_collection/{id}"
	}

	@GetMapping(resourcesPath)
	fun index(): ModelAndView {
		return ModelAndView("book_collection/index")
	}

//    @PostMapping(resourcesPath + "/search")
//    public Iterable<Book> search() {
//		return bookService.findBy()
//    }

	@GetMapping("$resourcesPath/image_search")
	fun searchByImage(): ModelAndView {
		return ModelAndView("book_colelction/image_search")
	}

	@PostMapping("$resourcesPath/image_search")
	fun searchByImage(@RequestParam image: MultipartFile,
					  redirectAttributes: RedirectAttributes): RedirectView {
		val isbn = bookService.extractISBNFromImage(image.resource)

		if (isbn == null) {
			redirectAttributes.addFlashAttribute("", "")
			return RedirectView("$resourcesPath/input")
		}
		return RedirectView("$resourcesPath/input?isbn=${isbn}")
	}

	@GetMapping("$resourcesPath/input")
	fun show(@RequestParam isbn: String) {
		// TODO
		return
	}
}
