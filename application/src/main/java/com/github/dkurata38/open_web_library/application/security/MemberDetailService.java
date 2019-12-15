package com.github.dkurata38.open_web_library.application.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Service
public class MemberDetailService implements UserDetailsService {
	private final MemberCredentialRepository memberCredentialRepository;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		if (StringUtils.isEmpty(username)) {
			throw new UsernameNotFoundException("not found:" + username);
		}

		return memberCredentialRepository.getMemberCredentialByLoginIdEquals(username)
			.map(memberCredential -> new User(username, memberCredential.getPassword(), AuthorityUtils.createAuthorityList("USER")))
			.orElseThrow(() -> new UsernameNotFoundException("not found:" + username));
	}
}
