package com.github.dkurata38.open_web_library.web.infrastructure.member;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.github.dkurata38.open_web_library.member_domain.Member;
import com.github.dkurata38.open_web_library.member_domain.MemberId;

@Mapper
public interface MemberMapper {
	Member selectByMemberId(@Param("memberId") MemberId memberId);
	void insert(Member member);
}
