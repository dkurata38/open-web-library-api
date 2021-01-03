package com.github.dkurata38.open_web_library.web.presentation.register_member;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterMemberForm {
	@NotBlank
	@UniqueUsername
	private String username;
	@NotBlank
	@Size(min = 8)

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
