package com.github.dkurata38.open_web_library.web.library

import org.springframework.stereotype.Controller

@Controller
class LibraryController {
	companion object {
		private const val resourcesPath = "libraries"
		private const val resourcePath = "library/{id}"
		private const val ownResourcePath = "library/{id}"
	}

}
