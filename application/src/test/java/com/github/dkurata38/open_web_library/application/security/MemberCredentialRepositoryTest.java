package com.github.dkurata38.open_web_library.application.security;

import com.github.dkurata38.open_web_library.domain.member.MemberCredential;
import com.github.dkurata38.open_web_library.domain.member.MemberCredentialId;
import com.github.dkurata38.open_web_library.domain.member.MemberId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = {MemberCredentialRepository.class})
@DataJdbcTest(properties = {"classpath:application-test"})
@Transactional
class MemberCredentialRepositoryTest {
	@Autowired
	private MemberCredentialRepository memberCredentialRepository;
	@Test
	void testFind() {
		MemberCredentialId memberCredentialId = MemberCredentialId.issue();
		MemberId memberId = MemberId.issue();
		memberCredentialRepository.save(new MemberCredential(memberCredentialId, memberId, "aaaa", "aaaa"));
		memberCredentialRepository.findById(memberCredentialId)
			.ifPresent(System.out::println);
	}
}
