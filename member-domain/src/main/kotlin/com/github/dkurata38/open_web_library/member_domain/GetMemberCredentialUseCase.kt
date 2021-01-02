package com.github.dkurata38.open_web_library.member_domain

interface GetMemberCredentialUseCase {
	fun getMemberCredentialByLoginId(loginId: String): MemberCredential?
}
