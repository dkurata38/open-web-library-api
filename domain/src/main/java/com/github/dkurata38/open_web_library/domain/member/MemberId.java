package com.github.dkurata38.open_web_library.domain.member;

import com.github.dkurata38.library.domain_lib.persistence.IdIssuer;
import com.github.dkurata38.library.domain_lib.persistence.Identifier;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class MemberId implements Identifier<MemberId> {
	@NotNull
	private final String value;

	private static IdIssuer<MemberId> idIssuer =
			new IdIssuer<>(MemberId::new);

	public static MemberId issue() {
		return idIssuer.issue();
	}

	@Override
	public Class<MemberId> getType() {
		return MemberId.class;
	}
}
