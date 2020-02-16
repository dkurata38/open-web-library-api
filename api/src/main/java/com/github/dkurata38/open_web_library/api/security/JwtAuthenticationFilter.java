package com.github.dkurata38.open_web_library.api.security;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {
	private final JwtTokenService jwtTokenService;
	private final MemberDetailService memberDetailService;

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
		Optional<String> resolveToken = resolveToken(request);
		if (resolveToken.isPresent()) {
			Optional<UserDetails> maybeUserDetails = authenticate(resolveToken.get());
			if (maybeUserDetails.isPresent()) {
				UserDetails userDetails = maybeUserDetails.get();
				SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()));
			} else {
				SecurityContextHolder.clearContext();
				((HttpServletResponse)response).sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
				return;
			}
		}
		chain.doFilter(request, response);
	}

	private Optional<UserDetails> authenticate(String token) {
		return jwtTokenService.verify(token)
				.map(memberId -> memberDetailService.loadUserByUsername(memberId.getValue()));
	}

	private Optional<String> resolveToken(ServletRequest request) {
		String token = ((HttpServletRequest) request).getHeader(HttpHeaders.AUTHORIZATION);
		if (token == null || !token.startsWith("Bearer ")) {
			return Optional.empty();
		}
		return Optional.of(token.substring(7));
	}
}
