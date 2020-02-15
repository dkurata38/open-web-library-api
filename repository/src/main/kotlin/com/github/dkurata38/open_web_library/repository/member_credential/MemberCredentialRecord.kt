/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.github.dkurata38.open_web_library.repository.member_credential

import java.time.LocalDateTime

data class MemberCredentialRecord(
		val memberCredentialId: String,
		val memberId: String,
		val loginId: String,
		val password: String,
		val createdAt: LocalDateTime,
		val updatedAt: LocalDateTime
)
