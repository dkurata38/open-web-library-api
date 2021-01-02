package com.github.dkurata38.open_web_library.member_domain

import java.time.LocalDateTime

class RegisterMemberUseCaseImpl(private val memberRepository: MemberRepository,
								private val memberCredentialRepository: MemberCredentialRepository) : RegisterMemberUseCase {
	override fun register(name: String, loginId: String, password: String) {
		val memberId = MemberId.issue()
		val registeredAt = LocalDateTime.now()

		val member = Member(memberId, name, registeredAt)
		memberRepository.save(member)

		val memberCredentialId = MemberCredentialId.issue()
		val memberCredential = MemberCredential(memberCredentialId, loginId, password)
		memberCredentialRepository.save(memberCredential)
	}
}
