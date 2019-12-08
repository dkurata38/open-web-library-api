package com.github.dkurata38.open_web_library.domain.member;

import com.github.dkurata38.open_web_library.domain.common.IdIssuer;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class MemberId {
	@NotNull
	private final String value;

	private static IdIssuer<MemberId> idIssuer =
			new IdIssuer<>(MemberId::new);

	public static MemberId issue() {
		return idIssuer.issue();
	}
}
