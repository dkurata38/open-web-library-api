package com.github.dkurata38.open_web_library.client.image_congnition

import com.github.dkurata38.open_web_library.application.book.ImageCognitionClient
import org.springframework.cloud.gcp.vision.CloudVisionTemplate
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class GoogleCloudVisionClient(private val cloudVisionTemplate: CloudVisionTemplate) : ImageCognitionClient {
	override fun extractTextFromImage(resource: Resource): String {
		return cloudVisionTemplate.extractTextFromImage(resource)
	}
}
