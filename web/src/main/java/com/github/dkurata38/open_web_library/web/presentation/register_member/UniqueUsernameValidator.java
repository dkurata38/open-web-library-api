package com.github.dkurata38.open_web_library.web.presentation.register_member;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.github.dkurata38.open_web_library.member_domain.GetMemberUseCase;
import com.github.dkurata38.open_web_library.member_domain.Member;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
	private final GetMemberUseCase getMemberUseCase;

	public UniqueUsernameValidator(GetMemberUseCase getMemberUseCase) {
		this.getMemberUseCase = getMemberUseCase;
	}

	@Override
	public void initialize(UniqueUsername constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		Member member = getMemberUseCase.getByUsername(value);
		return member != null;
	}
}
