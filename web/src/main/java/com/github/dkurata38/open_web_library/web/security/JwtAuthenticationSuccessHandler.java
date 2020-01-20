package com.github.dkurata38.open_web_library.web.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.github.dkurata38.open_web_library.domain.member.MemberId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

import static java.util.stream.Collectors.*;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private final JwtTokenService jwtTokenService;

	@Override
	public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException, ServletException {
		UserDetails userDetails = (UserDetails)authentication.getPrincipal();
		MemberId memberId = new MemberId(userDetails.getUsername());
		response.setHeader(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", jwtTokenService.issue(memberId)));
		response.setStatus(HttpStatus.OK.value());
		Optional.ofNullable(request.getSession(false))
			.ifPresent(httpSession -> httpSession.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION));
	}
}
