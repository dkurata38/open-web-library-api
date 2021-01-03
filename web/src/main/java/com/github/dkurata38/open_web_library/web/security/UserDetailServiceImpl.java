package com.github.dkurata38.open_web_library.web.security;

import java.util.Set;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.github.dkurata38.open_web_library.member_domain.GetMemberUseCase;
import com.github.dkurata38.open_web_library.member_domain.Member;

@Component
public class UserDetailServiceImpl implements UserDetailsService {
	private final GetMemberUseCase getMemberUseCase;

	public UserDetailServiceImpl(GetMemberUseCase getMemberUseCase) {
		this.getMemberUseCase = getMemberUseCase;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = getMemberUseCase.getByUsername(username);
		if (member == null) {
			throw new UsernameNotFoundException("user is not found");
		}
		return new User(member.getUsername(), member.getPassword(), Set.of(new SimpleGrantedAuthority("USER")));
	}
}
