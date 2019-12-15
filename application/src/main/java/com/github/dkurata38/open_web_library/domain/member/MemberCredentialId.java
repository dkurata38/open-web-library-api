package com.github.dkurata38.open_web_library.domain.member;

import com.github.dkurata38.open_web_library.domain.common.IdIssuer;
import com.github.dkurata38.open_web_library.domain.common.Identifier;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import static java.util.stream.Collectors.*;

@Value
public class MemberCredentialId implements Identifier<MemberCredentialId> {
	@Column("member_credential_id")
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
