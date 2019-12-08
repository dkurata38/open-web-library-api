package com.github.dkurata38.open_web_library.domain.member;

import com.github.dkurata38.open_web_library.domain.common.IdIssuer;
import lombok.Value;

import static java.util.stream.Collectors.*;

@Value
public class MemberCredentialId {
	private final String value;

	private static IdIssuer<MemberCredentialId> idIssuer = new IdIssuer<>(MemberCredentialId::new);
	public static MemberCredentialId issue() {
		return idIssuer.issue();
	}
}
