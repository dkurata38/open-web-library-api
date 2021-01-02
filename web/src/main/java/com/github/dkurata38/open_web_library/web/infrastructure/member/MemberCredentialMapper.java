package com.github.dkurata38.open_web_library.web.infrastructure.member;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.github.dkurata38.open_web_library.member_domain.MemberCredential;

@Mapper
public interface MemberCredentialMapper {
	MemberCredential selectByLoginId(@Param("loginId") String loginId);
	void insert(MemberCredential memberCredential);
}
