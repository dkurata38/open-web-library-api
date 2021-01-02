package com.github.dkurata38.open_web_library.web.infrastructure.member;

import java.util.function.Function;
import com.github.dkurata38.open_web_library.member_domain.MemberCredentialId;
import com.github.dkurata38.open_web_library.web.infrastructure.common.StringValueTypeHandler;

public class MemberCredentialIdTypeHandler extends StringValueTypeHandler<MemberCredentialId> {
	public MemberCredentialIdTypeHandler() {
		super(MemberCredentialId::getValue, MemberCredentialId::new);
	}
}
