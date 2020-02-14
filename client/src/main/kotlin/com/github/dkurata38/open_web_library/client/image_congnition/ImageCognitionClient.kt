package com.github.dkurata38.open_web_library.client.image_congnition;

import org.springframework.cloud.gcp.vision.CloudVisionTemplate
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class ImageCognitionClient(private val cloudVisionTemplate: CloudVisionTemplate) {
	fun extractTextFromImage(resource: Resource): String {
		return cloudVisionTemplate.extractTextFromImage(resource)
	}
}
