package com.github.dkurata38.open_web_library.api.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.github.dkurata38.open_web_library.domain.member.MemberId;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.Date;
import java.util.Optional;

@Service
public final class JwtTokenService {

	private final JwtProperties jwtProperties;
	private final Algorithm algorithm;

	public JwtTokenService(final JwtProperties jwtProperties) {
		this.jwtProperties = jwtProperties;
		this.algorithm = Algorithm.HMAC256(jwtProperties.getSecurityKey());
	}

	public String issue(MemberId memberId) {
		Duration validityTime = jwtProperties.getValidityTime();
		LocalDateTime now = LocalDateTime.now();
		ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
		Date issuedAt = Date.from(zonedDateTime.toInstant());
		Date expiresAt = Date.from(Instant.from(validityTime.addTo(zonedDateTime)));
		return JWT.create()
				.withIssuedAt(issuedAt)
				.withNotBefore(issuedAt)
				.withExpiresAt(expiresAt)
				.withSubject(memberId.getValue())
				.sign(this.algorithm);
	}

	public Optional<MemberId> verify(String token) {
		JWTVerifier verifier = JWT.require(algorithm).build();
		try {
			DecodedJWT decodedJWT = verifier.verify(token);
			return Optional.of(new MemberId(decodedJWT.getSubject()));
		} catch (JWTVerificationException e) {
			return Optional.empty();
		}
	}
}
