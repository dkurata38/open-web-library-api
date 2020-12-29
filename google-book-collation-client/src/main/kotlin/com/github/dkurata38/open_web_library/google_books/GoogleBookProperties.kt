package com.github.dkurata38.open_web_library.google_books

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "google-book")
@ConstructorBinding
data class GoogleBookProperties(val apiKey: String) {
}
