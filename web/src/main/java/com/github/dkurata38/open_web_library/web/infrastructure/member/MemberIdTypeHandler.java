package com.github.dkurata38.open_web_library.web.infrastructure.member;

import java.util.function.Function;
import com.github.dkurata38.open_web_library.member_domain.MemberId;
import com.github.dkurata38.open_web_library.web.infrastructure.common.StringValueTypeHandler;

public class MemberIdTypeHandler extends StringValueTypeHandler<MemberId> {
	public MemberIdTypeHandler() {
		super(MemberId::getValue, MemberId::new);
	}
}
