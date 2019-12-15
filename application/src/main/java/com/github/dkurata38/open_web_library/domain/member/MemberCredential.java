package com.github.dkurata38.open_web_library.domain.member;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

import static java.util.stream.Collectors.*;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode(of = {"memberCredentialId"})
public class MemberCredential {
	@Id
	@Embedded.Empty
	private final MemberCredentialId memberCredentialId;
	@Embedded.Empty
	private final MemberId memberId;
	private final String loginId;
	private final String password;
}
