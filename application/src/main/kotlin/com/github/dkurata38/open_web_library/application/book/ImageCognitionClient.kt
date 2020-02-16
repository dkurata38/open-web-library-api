package com.github.dkurata38.open_web_library.application.book

import org.springframework.core.io.Resource

interface ImageCognitionClient {
	fun extractTextFromImage(resource: Resource): String
}
