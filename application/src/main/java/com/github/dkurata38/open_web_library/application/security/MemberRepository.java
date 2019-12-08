package com.github.dkurata38.open_web_library.application.security;

import com.github.dkurata38.open_web_library.domain.member.Member;
import com.github.dkurata38.open_web_library.domain.member.MemberId;
import org.springframework.data.repository.CrudRepository;

import static java.util.stream.Collectors.*;

public interface MemberRepository extends CrudRepository<Member, MemberId> {
}
