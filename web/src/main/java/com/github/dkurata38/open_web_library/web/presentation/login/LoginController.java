package com.github.dkurata38.open_web_library.web.presentation.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("login")
	public String viewLogin() {
		return "login/login";
	}
}
