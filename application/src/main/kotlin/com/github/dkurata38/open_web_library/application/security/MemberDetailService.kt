package com.github.dkurata38.open_web_library.application.security

import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import com.github.dkurata38.open_web_library.repository.member_credential.MemberCredentialRepository

@Service
class MemberDetailService(private val memberCredentialRepository: MemberCredentialRepository): UserDetailsService {

	override fun loadUserByUsername(username: String): UserDetails {
		if (StringUtils.isEmpty(username)) {
			throw UsernameNotFoundException("not found:$username")
		}

		return memberCredentialRepository.getMemberCredentialByLoginIdEquals(username)
			?.let { User(username, it.password, AuthorityUtils.createAuthorityList("USER")) }
				?: throw UsernameNotFoundException("not found:$username")
	}
}
