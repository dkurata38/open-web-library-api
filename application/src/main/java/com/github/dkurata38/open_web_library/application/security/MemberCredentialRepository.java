package com.github.dkurata38.open_web_library.application.security;

import com.github.dkurata38.open_web_library.domain.member.MemberCredential;
import com.github.dkurata38.open_web_library.domain.member.MemberCredentialId;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import static java.util.stream.Collectors.*;

public interface MemberCredentialRepository extends CrudRepository<MemberCredential, MemberCredentialId> {
	@Query("SELECT * FROM member_credential WHERE login_id = :loginId")
	Optional<MemberCredential> findMemberCredentialByLoginId(String loginId);
}
