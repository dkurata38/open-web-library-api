package com.github.dkurata38.open_web_library.web.library;

import java.util.Map;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.github.dkurata38.open_web_library.library_domain.AddLibraryItemUseCase;

@Controller
@RequestMapping("library_items")
@SessionAttributes
public class AddLibraryItemController {
	String errorAttributeName = "error";

	private final AddLibraryItemUseCase addLibraryItemUseCase;

	public AddLibraryItemController(AddLibraryItemUseCase addLibraryItemUseCase) {
		this.addLibraryItemUseCase = addLibraryItemUseCase;
	}

	@GetMapping("add")
	public String input(@RequestParam(required = false, defaultValue = "false") Boolean isBack,  Model model) {
		Map<String, Object> modelMap = model.asMap();
		if (isBack && modelMap.containsKey(errorAttributeName)) {
			BindingResult bindingResult = (BindingResult) modelMap.get(errorAttributeName);
			model.addAttribute(BindingResult.MODEL_KEY_PREFIX + bindingResult.getObjectName(), bindingResult);
		}

		if (!isBack) {
			model.addAttribute("addLibraryItemForm", new AddLibraryItemForm());
		}
		return "library_item/add_library_input";
	}

	@PostMapping("add")
	public String add(@ModelAttribute @Validated AddLibraryItemForm addLibraryItemForm,
					  BindingResult bindingResult,
					  SessionStatus sessionStatus,
					  RedirectAttributes redirectAttributes//,
//					  @AuthenticationPrincipal UserDetails userDetails
	) {
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute(errorAttributeName, bindingResult);
			return "redirect:/library_items/add";
		}
		addLibraryItemUseCase.add(
				addLibraryItemForm.getTitle(),
				addLibraryItemForm.getAuthorName(),
				addLibraryItemForm.getPublisherName(),
				addLibraryItemForm.getOnSaleDate(),
				addLibraryItemForm.getLanguage(),
				addLibraryItemForm.getIsbn(),
				"1"
		);
		sessionStatus.setComplete();
		return "redirect:/library_items/";
	}
}
