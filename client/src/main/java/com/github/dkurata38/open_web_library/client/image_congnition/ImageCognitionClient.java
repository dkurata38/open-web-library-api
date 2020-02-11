package com.github.dkurata38.open_web_library.client.image_congnition;

import lombok.RequiredArgsConstructor;

import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ImageCognitionClient {

	private final CloudVisionTemplate cloudVisionTemplate;
	public String extractTextFromImage(Resource resource) {
		return cloudVisionTemplate.extractTextFromImage(resource);
	}
}
