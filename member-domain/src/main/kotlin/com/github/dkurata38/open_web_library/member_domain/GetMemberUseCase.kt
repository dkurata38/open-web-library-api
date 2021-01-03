package com.github.dkurata38.open_web_library.member_domain

interface GetMemberUseCase {
	fun getByMemberId(memberId: String): Member?

	fun getByUsername(username: String): Member?
}
