package com.github.dkurata38.open_web_library.application.book;

import org.springframework.core.io.Resource;

public interface ImageCognitionClient {
	String extractTextFromImage(Resource resource);
}
