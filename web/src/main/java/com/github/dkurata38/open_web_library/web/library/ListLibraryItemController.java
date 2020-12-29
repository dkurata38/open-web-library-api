package com.github.dkurata38.open_web_library.web.library;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.dkurata38.open_web_library.library_domain.GetLibraryItemUseCase;
import com.github.dkurata38.open_web_library.library_domain.LibraryItem;

@RequestMapping("library_items")
@Controller
public class ListLibraryItemController {
	private final GetLibraryItemUseCase getLibraryItemUseCase;

	public ListLibraryItemController(GetLibraryItemUseCase getLibraryItemUseCase) {
		this.getLibraryItemUseCase = getLibraryItemUseCase;
	}

	@GetMapping("")
	public String index(Model model) {
		String ownerId = "1";
		List<LibraryItem> libraryItems = getLibraryItemUseCase.getByOwnerId(ownerId);
		model.addAttribute("libraryItems", libraryItems);
		return "library_item/index";
	}
}
