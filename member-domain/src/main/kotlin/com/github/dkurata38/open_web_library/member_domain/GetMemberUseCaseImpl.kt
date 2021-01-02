package com.github.dkurata38.open_web_library.member_domain

class GetMemberUseCaseImpl(private val memberRepository: MemberRepository) : GetMemberUseCase {
	override fun getByMemberId(memberId: String): Member? {
		return memberRepository.findByMemberId(MemberId(memberId))
	}
}
