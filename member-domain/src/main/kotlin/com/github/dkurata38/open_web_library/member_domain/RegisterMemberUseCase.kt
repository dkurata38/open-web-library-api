package com.github.dkurata38.open_web_library.member_domain

interface RegisterMemberUseCase {
	fun register(username: String, password: String)
}
