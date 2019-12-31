package com.github.dkurata38.open_web_library.domain.member;

import com.github.dkurata38.library.domain_lib.persistence.IdIssuer;
import com.github.dkurata38.library.domain_lib.persistence.Identifier;
import lombok.Value;

@Value
public class MemberCredentialId implements Identifier<MemberCredentialId> {
	private final String value;

	private static IdIssuer<MemberCredentialId> idIssuer = new IdIssuer<>(MemberCredentialId::new);
	public static MemberCredentialId issue() {
		return idIssuer.issue();
	}

	@Override
	public Class<MemberCredentialId> getType() {
		return MemberCredentialId.class;
	}
}
