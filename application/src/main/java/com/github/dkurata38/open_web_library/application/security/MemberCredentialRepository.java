package com.github.dkurata38.open_web_library.application.security;

import com.github.dkurata38.open_web_library.domain.member.MemberCredential;

import java.util.Optional;

public interface MemberCredentialRepository {
	Optional<MemberCredential> getMemberCredentialByLoginIdEquals(String loginId);
}
