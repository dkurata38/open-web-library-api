package com.github.dkurata38.open_web_library.client;

import com.github.dkurata38.open_web_library.client.image_congnition.ImageCognitionClient
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.ResourceLoader

@SpringBootTest
class ImageCognitionClientTest(@Autowired private val imageCognitionClient: ImageCognitionClient,
                               @Autowired private val resourceLoader: ResourceLoader) {

    @Test
    fun getContents() {
        val resource =
                resourceLoader.getResource("classpath:Test2.jpg")
        val contents = imageCognitionClient.extractTextFromImage(resource)
        Assertions.assertNotNull(contents)
    }
}
