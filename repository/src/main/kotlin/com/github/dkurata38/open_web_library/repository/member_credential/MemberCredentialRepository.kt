package com.github.dkurata38.open_web_library.repository.member_credential

import com.github.dkurata38.open_web_library.domain.member.MemberCredential
import com.github.dkurata38.open_web_library.domain.member.MemberCredentialId
import com.github.dkurata38.open_web_library.domain.member.MemberId
import com.github.dkurata38.open_web_library.repository.common.BaseRepository
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.springframework.stereotype.Repository

@Repository
class MemberCredentialRepository(private val memberCredentialMapper: MemberCredentialMapper): BaseRepository<MemberCredential, MemberCredentialRecord>(
		{
			memberCredential -> MemberCredentialRecord(
				memberCredential.memberCredentialId.value,
				memberCredential.memberId.value,
				memberCredential.loginId,
				memberCredential.password
		)},
		{
			memberCredentialTableRecord -> MemberCredential(
				MemberCredentialId(memberCredentialTableRecord.memberCredentialId!!),
				MemberId(memberCredentialTableRecord.memberId!!),
				memberCredentialTableRecord.loginId!!,
				memberCredentialTableRecord.password!!
		)}) {

	fun getMemberCredentialByLoginIdEquals(loginId: String): MemberCredential? {
		val memberCredentialRecord = memberCredentialMapper.selectOne {
			where(MemberCredentialDynamicSqlSupport.MemberCredential.loginId, isEqualTo(loginId))
		}
		return memberCredentialRecord
				?.let { converterToModel(it) }
	}
}
