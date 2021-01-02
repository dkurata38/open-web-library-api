package com.github.dkurata38.open_web_library.member_domain

import java.time.LocalDateTime

data class Member(val id: MemberId, val name: String, val registeredAt: LocalDateTime) {
}

data class MemberId(val value: String) {
	companion object {
		fun issue(): MemberId {
			return MemberId(IdIssuer.generateIdValue())
		}
	}
}
