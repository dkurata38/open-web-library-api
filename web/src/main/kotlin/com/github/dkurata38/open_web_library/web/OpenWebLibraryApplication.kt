package com.github.dkurata38.open_web_library.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.web.client.RestTemplate

@SpringBootApplication(scanBasePackages = [
	"com.github.dkurata38.open_web_library.repository.*",
	"com.github.dkurata38.open_web_library.client",
	"com.github.dkurata38.open_web_library.application.*",
	"com.github.dkurata38.open_web_library.web.*"
])
@ConfigurationPropertiesScan
class OpenWebLibraryApplication

fun main(args: Array<String>) {
	runApplication<OpenWebLibraryApplication>(*args)
}

@Bean
fun propertySourcesPlaceholderConfigurer(): PropertySourcesPlaceholderConfigurer {
	return PropertySourcesPlaceholderConfigurer()
}

@Bean
fun restTemplate(): RestTemplate {
	return RestTemplateBuilder().build()
}

