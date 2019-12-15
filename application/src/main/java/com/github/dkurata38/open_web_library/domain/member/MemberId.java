package com.github.dkurata38.open_web_library.domain.member;

import com.github.dkurata38.open_web_library.domain.common.IdIssuer;
import com.github.dkurata38.open_web_library.domain.common.Identifier;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import javax.validation.constraints.NotNull;

@Value
public class MemberId implements Identifier<MemberId> {
	@NotNull
	@Column("member_id")
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
