package com.github.dkurata38.open_web_library.web.api.library;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import static java.util.stream.Collectors.*;

@Controller
@RequiredArgsConstructor
public class LibraryController {
	private static final String resourcesPath = "libraries";
	private static final String resourcePath = "library/{id}";
	private static final String ownResourcePath = "library/{id}";

}
