package com.github.dkurata38.open_web_library.member_domain

interface MemberCredentialRepository {
	fun save(memberCredential: MemberCredential)
	fun findByLoginId(loginId: String): MemberCredential?
}
