package com.github.dkurata38.open_web_library.infra.client;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoogleCloudVisionClient implements ImageCognitionClient {

	private final CloudVisionTemplate cloudVisionTemplate;

	@Override
	public String getContents(Resource resource) {
		return cloudVisionTemplate.extractTextFromImage(resource);
	}
}
