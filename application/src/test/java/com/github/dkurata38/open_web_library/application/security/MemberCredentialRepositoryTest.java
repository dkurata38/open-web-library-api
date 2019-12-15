package com.github.dkurata38.open_web_library.application.security;

import com.github.dkurata38.open_web_library.domain.member.MemberCredential;
import com.github.dkurata38.open_web_library.domain.member.MemberCredentialId;
import com.github.dkurata38.open_web_library.domain.member.MemberId;
import com.github.dkurata38.open_web_library.web.config.JdbcConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJdbcTest
@Transactional
//@Import(JdbcConfig.class)
@Slf4j
class MemberCredentialRepositoryTest {
	@Autowired
	private MemberCredentialRepository memberCredentialRepository;
	@Test
	@Sql(statements = {
			"INSERT INTO member(member_id, name) VALUES ('bbbb', 'eeee')",
			"INSERT INTO member_credential(member_credential_id, member_id, login_id, password) VALUES('aaaa', 'bbbb', 'cccc', 'dddd')"
	})
	void testFindByLoginId() {
		Iterable<MemberCredential> memberCredentials = memberCredentialRepository.findAll();
		memberCredentials
			.forEach(memberCredential -> log.info(memberCredential.toString()));
	}

	@Test
	void testSave() {
		MemberCredentialId memberCredentialId = MemberCredentialId.issue();
		MemberId memberId = MemberId.issue();
		MemberCredential memberCredential = new MemberCredential(memberCredentialId, memberId, "aaaa", "bbbb");
		memberCredentialRepository.save(memberCredential);
	}
}
