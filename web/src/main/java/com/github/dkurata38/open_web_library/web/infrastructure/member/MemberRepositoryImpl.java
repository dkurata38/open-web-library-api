package com.github.dkurata38.open_web_library.web.infrastructure.member;

import org.springframework.stereotype.Repository;
import com.github.dkurata38.open_web_library.member_domain.Member;
import com.github.dkurata38.open_web_library.member_domain.MemberId;
import com.github.dkurata38.open_web_library.member_domain.MemberRepository;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	private final MemberMapper memberMapper;

	public MemberRepositoryImpl(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

	@Override
	public Member findByMemberId(MemberId memberId) {
		return memberMapper.selectByMemberId(memberId);
	}

	@Override
	public void save(Member member) {
		memberMapper.insert(member);
	}

	@Override
	public Member findByUsername(String username) {
		return memberMapper.selectByUsername(username);
	}
}
