package com.github.dkurata38.open_web_library.web.presentation.register_member;

import java.util.Map;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.github.dkurata38.open_web_library.member_domain.RegisterMemberUseCase;

@Controller
@RequestMapping("register_member")
public class RegisterMemberController {
	String errorAttributeName = "error";

	private final RegisterMemberUseCase registerMemberUseCase;

	private final PasswordEncoder passwordEncoder;

	public RegisterMemberController(RegisterMemberUseCase registerMemberUseCase, PasswordEncoder passwordEncoder) {
		this.registerMemberUseCase = registerMemberUseCase;
		this.passwordEncoder = passwordEncoder;
	}

	@ModelAttribute
	public RegisterMemberForm registerMemberForm() {
		return new RegisterMemberForm();
	}

	@GetMapping("register")
	public String viewRegister(RegisterMemberForm registerMemberForm,
							   @RequestParam(name = "isBack", required = false, defaultValue = "false") Boolean isBack,
							   Model model) {
		Map<String, Object> modelMap = model.asMap();
		if (isBack && modelMap.containsKey(errorAttributeName)) {
			BindingResult bindingResult = (BindingResult) modelMap.get(errorAttributeName);
			model.addAttribute(BindingResult.MODEL_KEY_PREFIX + bindingResult.getObjectName(), bindingResult);
		}

		return "register_member/register";
	}

	@PostMapping("register")
	public String register(@ModelAttribute @Validated RegisterMemberForm registerMemberForm,
						   BindingResult bindingResult,
						   RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute(errorAttributeName, bindingResult);
			return "redirect:/register_member/register?isBack=true";
		}
		// process
		registerMemberUseCase.register(registerMemberForm.getUsername(), passwordEncoder.encode(registerMemberForm.getPassword()));

		return "redirect:/register_member/registered";
	}

	@GetMapping("registered")
	public String viewRegistered() {
		return "register_member/registered";
	}
}
