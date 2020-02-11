package com.github.dkurata38.open_web_library

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer

@SpringBootApplication(scanBasePackages = [
	"com.github.dkurata38.open_web_library.*"
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
