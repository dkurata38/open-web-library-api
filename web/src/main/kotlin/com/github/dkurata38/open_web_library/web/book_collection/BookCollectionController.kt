package com.github.dkurata38.open_web_library.web.book_collection

import com.github.dkurata38.open_web_library.application.book.BookService
import com.github.dkurata38.open_web_library.domain.book.ISBN
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
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
	fun searchBookByImage(): ModelAndView {
		return ModelAndView("book_collection/image_search")
	}

	@PostMapping("$resourcesPath/image_search")
	fun searchBookByImage(@RequestParam image: MultipartFile,
						  redirectAttributes: RedirectAttributes): RedirectView {
		val isbn = bookService.extractISBNFromImage(image.resource)

		if (isbn == null) {
			redirectAttributes.addFlashAttribute("", "")
			return RedirectView("$resourcesPath/image_search")
		}
		return RedirectView("$resourcesPath/input?isbn=${isbn.value}")
	}

	@GetMapping("$resourcesPath/input")
	fun putBook(@RequestParam isbn: ISBN,
				@AuthenticationPrincipal user: User,
				redirectAttributes: RedirectAttributes): ModelAndView {
		val bookSummary = bookService.findByISBN(isbn)
		if (bookSummary == null) {
			redirectAttributes.addFlashAttribute("", "")
			return ModelAndView("book_collection/input")

		}
		return ModelAndView("book_collection/input")
				.addObject("bookSummary", bookSummary)
	}
}