package com.github.dkurata38.open_web_library.member_domain

class GetMemberCredentialUseCaseImpl(private val memberCredentialRepository: MemberCredentialRepository) : GetMemberCredentialUseCase {
	override fun getMemberCredentialByLoginId(loginId: String): MemberCredential? {
		return memberCredentialRepository.findByLoginId(loginId)
	}
}
