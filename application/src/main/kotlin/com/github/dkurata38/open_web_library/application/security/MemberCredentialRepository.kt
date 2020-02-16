package com.github.dkurata38.open_web_library.application.security

import com.github.dkurata38.open_web_library.domain.member.MemberCredential

interface MemberCredentialRepository {
	fun getMemberCredentialByLoginIdEquals(loginId: String): MemberCredential?
}
