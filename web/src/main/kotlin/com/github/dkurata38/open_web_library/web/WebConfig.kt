package com.github.dkurata38.open_web_library.web

import com.github.dkurata38.open_web_library.web.converters.ISBNConverter
import org.springframework.context.annotation.Configuration
import org.springframework.format.FormatterRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {
	override fun addFormatters(registry: FormatterRegistry) {
		registry.addConverter(ISBNConverter())
	}
}
