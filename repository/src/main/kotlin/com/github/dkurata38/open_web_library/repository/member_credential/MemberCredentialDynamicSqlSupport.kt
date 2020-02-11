/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.github.dkurata38.open_web_library.repository.member_credential

import java.sql.JDBCType
import java.time.LocalDateTime
import org.mybatis.dynamic.sql.SqlTable

object MemberCredentialDynamicSqlSupport {
    object MemberCredential : SqlTable("member_credential") {
        val memberCredentialId = column<String>("member_credential_id", JDBCType.VARCHAR)

        val memberId = column<String>("member_id", JDBCType.VARCHAR)

        val loginId = column<String>("login_id", JDBCType.VARCHAR)

        val password = column<String>("password", JDBCType.VARCHAR)

        val createdAt = column<LocalDateTime>("created_at", JDBCType.TIMESTAMP)

        val updatedAt = column<LocalDateTime>("updated_at", JDBCType.TIMESTAMP)
    }
}
