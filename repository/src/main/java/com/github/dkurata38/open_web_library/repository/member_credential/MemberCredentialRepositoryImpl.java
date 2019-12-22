package com.github.dkurata38.open_web_library.repository.member_credential;

import com.github.dkurata38.open_web_library.application.security.MemberCredentialRepository;
import com.github.dkurata38.open_web_library.domain.member.MemberCredential;
import com.github.dkurata38.open_web_library.domain.member.MemberCredentialId;
import com.github.dkurata38.open_web_library.domain.member.MemberId;
import com.github.dkurata38.open_web_library.repository.common.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Function;


@Repository
public class MemberCredentialRepositoryImpl extends BaseRepository<MemberCredential, MemberCredentialTable> implements MemberCredentialRepository {
	private final MemberCredentialTableMapper memberCredentialMapper;

	private static final Function<MemberCredential, MemberCredentialTable> toTable =
			memberCredential -> {
				MemberCredentialTable table = new MemberCredentialTable();
				table.setMemberCredentialId(memberCredential.getMemberCredentialId().getValue());
				table.setMemberId(memberCredential.getMemberId().getValue());
				table.setLoginId(memberCredential.getLoginId());
				table.setPassword(memberCredential.getPassword());
				return table;
			};

	private static final Function<MemberCredentialTable, MemberCredential> toModel =
			memberCredentialTable -> new MemberCredential(
					new MemberCredentialId(memberCredentialTable.getMemberCredentialId()),
					new MemberId(memberCredentialTable.getMemberId()),
					memberCredentialTable.getLoginId(),
					memberCredentialTable.getPassword()
			);

	public MemberCredentialRepositoryImpl(final MemberCredentialTableMapper memberCredentialMapper) {
		super(toTable, toModel);
		this.memberCredentialMapper = memberCredentialMapper;
	}

	public Optional<MemberCredential> getMemberCredentialByLoginIdEquals(String loginId) {
		return Optional.ofNullable(memberCredentialMapper.selectByLoginId(loginId))
				.map(this::convertToModel);
	}
}
