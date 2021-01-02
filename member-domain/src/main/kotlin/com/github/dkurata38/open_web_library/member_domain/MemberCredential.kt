package com.github.dkurata38.open_web_library.member_domain

data class MemberCredential(val id: MemberCredentialId, val loginId: String, val password: String) {
}

data class MemberCredentialId(val value: String) {
	companion object {
		fun issue(): MemberCredentialId {
			return MemberCredentialId(IdIssuer.generateIdValue())
		}
	}
}
