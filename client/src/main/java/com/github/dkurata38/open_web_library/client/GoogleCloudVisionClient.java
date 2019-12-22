package com.github.dkurata38.open_web_library.client;

import com.github.dkurata38.open_web_library.application.book.ImageCognitionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoogleCloudVisionClient implements ImageCognitionClient {

	private final CloudVisionTemplate cloudVisionTemplate;

	@Override
	public String extractTextFromImage(Resource resource) {
		return cloudVisionTemplate.extractTextFromImage(resource);
	}
}
