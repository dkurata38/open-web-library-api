package com.github.dkurata38.open_web_library.api.security;

import lombok.RequiredArgsConstructor;

import java.util.Optional;
import com.github.dkurata38.open_web_library.application.member_credential.MemberCredentialRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberDetailService implements UserDetailsService {

	private final MemberCredentialRepository memberCredentialRepository;

	public UserDetails loadUserByUsername(String username) {
		if (username.isEmpty()) {
			throw new UsernameNotFoundException("not found:$username");
		}

		return Optional.ofNullable(memberCredentialRepository.getMemberCredentialByLoginIdEquals(username))
				.map(memberCredential -> new User(username, memberCredential.getPassword(), AuthorityUtils.createAuthorityList("USER")))
				.orElseThrow(() -> new UsernameNotFoundException("not found:$username"));
	}
}
