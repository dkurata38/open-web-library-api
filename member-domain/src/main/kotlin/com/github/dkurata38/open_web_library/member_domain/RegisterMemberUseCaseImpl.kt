package com.github.dkurata38.open_web_library.member_domain

import java.time.LocalDateTime

class RegisterMemberUseCaseImpl(private val memberRepository: MemberRepository) : RegisterMemberUseCase {
	override fun register(username: String, password: String) {
		val memberId = MemberId.issue()
		val registeredAt = LocalDateTime.now()

		val member = Member(memberId, username, password, registeredAt)
		memberRepository.save(member)
	}
}
