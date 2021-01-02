package com.github.dkurata38.open_web_library.web.infrastructure.member;

import org.springframework.stereotype.Repository;
import com.github.dkurata38.open_web_library.member_domain.MemberCredential;
import com.github.dkurata38.open_web_library.member_domain.MemberCredentialRepository;

@Repository
public class MemberCredentialRepositoryImpl implements MemberCredentialRepository {
	private final MemberCredentialMapper memberCredentialMapper;

	public MemberCredentialRepositoryImpl(MemberCredentialMapper memberCredentialMapper) {
		this.memberCredentialMapper = memberCredentialMapper;
	}

	@Override
	public void save(MemberCredential memberCredential) {
		memberCredentialMapper.insert(memberCredential);
	}

	@Override
	public MemberCredential findByLoginId(String loginId) {
		return memberCredentialMapper.selectByLoginId(loginId);
	}
}
