package com.github.dkurata38.open_web_library.domain.member;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode(of = {"memberCredentialId"})
public class MemberCredential {
	private final MemberCredentialId memberCredentialId;
	private final MemberId memberId;
	private final String loginId;
	private final String password;
}
