package com.github.dkurata38.open_web_library.infra.client;

import org.springframework.core.io.Resource;

public interface ImageCognitionClient {
	String getContents(Resource resource);
}
