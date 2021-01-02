package com.github.dkurata38.open_web_library.member_domain

interface MemberRepository {
	fun findByMemberId(memberId: MemberId): Member?
	fun save(member: Member)
}
