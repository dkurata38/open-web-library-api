/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.github.dkurata38.open_web_library.repository.member_credential

import com.github.dkurata38.open_web_library.repository.member_credential.MemberCredentialRecord
import org.apache.ibatis.annotations.DeleteProvider
import org.apache.ibatis.annotations.InsertProvider
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.annotations.UpdateProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter

@Mapper
interface MemberCredentialMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    fun count(selectStatement: SelectStatementProvider): Long

    @DeleteProvider(type=SqlProviderAdapter::class, method="delete")
    fun delete(deleteStatement: DeleteStatementProvider): Int

    @InsertProvider(type=SqlProviderAdapter::class, method="insert")
    fun insert(insertStatement: InsertStatementProvider<MemberCredentialRecord>): Int

    @InsertProvider(type=SqlProviderAdapter::class, method="insertMultiple")
    fun insertMultiple(multipleInsertStatement: MultiRowInsertStatementProvider<MemberCredentialRecord>): Int

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("MemberCredentialRecordResult")
    fun selectOne(selectStatement: SelectStatementProvider): MemberCredentialRecord?

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="MemberCredentialRecordResult", value = [
        Result(column="member_credential_id", property="memberCredentialId", jdbcType=JdbcType.VARCHAR, id=true),
        Result(column="member_id", property="memberId", jdbcType=JdbcType.VARCHAR),
        Result(column="login_id", property="loginId", jdbcType=JdbcType.VARCHAR),
        Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<MemberCredentialRecord>

    @UpdateProvider(type=SqlProviderAdapter::class, method="update")
    fun update(updateStatement: UpdateStatementProvider): Int
}
