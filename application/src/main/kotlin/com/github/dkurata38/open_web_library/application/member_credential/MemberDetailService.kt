package com.github.dkurata38.open_web_library.application.member_credential

import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MemberDetailService(private val memberCredentialRepository: MemberCredentialRepository): UserDetailsService {

	override fun loadUserByUsername(username: String): UserDetails {
		if (username.isEmpty()) {
			throw UsernameNotFoundException("not found:$username")
		}

		return memberCredentialRepository.getMemberCredentialByLoginIdEquals(username)
				?.let { User(username, it.password, AuthorityUtils.createAuthorityList("USER")) }
				?: throw UsernameNotFoundException("not found:$username")
	}
}
