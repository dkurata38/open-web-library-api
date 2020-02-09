package com.github.dkurata38.open_web_library.client;

import com.github.dkurata38.open_web_library.application.book.ImageCognitionClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@SpringBootTest
@Slf4j
class ImageCognitionClientTest {

	@Autowired
	private ImageCognitionClient imageCognitionClient;
	@Autowired
	private ResourceLoader resourceLoader;

//	@Test
	void getContents() {
		Resource resource =
				resourceLoader.getResource("classpath:Test2.jpg");
		String contents = imageCognitionClient.extractTextFromImage(resource);
		log.info(contents);
	}
}