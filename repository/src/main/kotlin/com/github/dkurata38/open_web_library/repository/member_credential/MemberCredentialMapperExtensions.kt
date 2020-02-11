/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.github.dkurata38.open_web_library.repository.member_credential

import com.github.dkurata38.open_web_library.repository.member_credential.MemberCredentialDynamicSqlSupport.MemberCredential
import com.github.dkurata38.open_web_library.repository.member_credential.MemberCredentialDynamicSqlSupport.MemberCredential.createdAt
import com.github.dkurata38.open_web_library.repository.member_credential.MemberCredentialDynamicSqlSupport.MemberCredential.loginId
import com.github.dkurata38.open_web_library.repository.member_credential.MemberCredentialDynamicSqlSupport.MemberCredential.memberCredentialId
import com.github.dkurata38.open_web_library.repository.member_credential.MemberCredentialDynamicSqlSupport.MemberCredential.memberId
import com.github.dkurata38.open_web_library.repository.member_credential.MemberCredentialDynamicSqlSupport.MemberCredential.password
import com.github.dkurata38.open_web_library.repository.member_credential.MemberCredentialDynamicSqlSupport.MemberCredential.updatedAt
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun MemberCredentialMapper.count(completer: CountCompleter) =
    countFrom(this::count, MemberCredential, completer)

fun MemberCredentialMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, MemberCredential, completer)

fun MemberCredentialMapper.deleteByPrimaryKey(memberCredentialId_: String) =
    delete {
        where(memberCredentialId, isEqualTo(memberCredentialId_))
    }

fun MemberCredentialMapper.insert(record: MemberCredentialRecord) =
    insert(this::insert, record, MemberCredential) {
        map(memberCredentialId).toProperty("memberCredentialId")
        map(memberId).toProperty("memberId")
        map(loginId).toProperty("loginId")
        map(password).toProperty("password")
        map(createdAt).toProperty("createdAt")
        map(updatedAt).toProperty("updatedAt")
    }

fun MemberCredentialMapper.insertMultiple(records: Collection<MemberCredentialRecord>) =
    insertMultiple(this::insertMultiple, records, MemberCredential) {
        map(memberCredentialId).toProperty("memberCredentialId")
        map(memberId).toProperty("memberId")
        map(loginId).toProperty("loginId")
        map(password).toProperty("password")
        map(createdAt).toProperty("createdAt")
        map(updatedAt).toProperty("updatedAt")
    }

fun MemberCredentialMapper.insertMultiple(vararg records: MemberCredentialRecord) =
    insertMultiple(records.toList())

fun MemberCredentialMapper.insertSelective(record: MemberCredentialRecord) =
    insert(this::insert, record, MemberCredential) {
        map(memberCredentialId).toPropertyWhenPresent("memberCredentialId", record::memberCredentialId)
        map(memberId).toPropertyWhenPresent("memberId", record::memberId)
        map(loginId).toPropertyWhenPresent("loginId", record::loginId)
        map(password).toPropertyWhenPresent("password", record::password)
        map(createdAt).toPropertyWhenPresent("createdAt", record::createdAt)
        map(updatedAt).toPropertyWhenPresent("updatedAt", record::updatedAt)
    }

private val columnList = listOf(memberCredentialId, memberId, loginId, password, createdAt, updatedAt)

fun MemberCredentialMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, MemberCredential, completer)

fun MemberCredentialMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, MemberCredential, completer)

fun MemberCredentialMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, MemberCredential, completer)

fun MemberCredentialMapper.selectByPrimaryKey(memberCredentialId_: String) =
    selectOne {
        where(memberCredentialId, isEqualTo(memberCredentialId_))
    }

fun MemberCredentialMapper.update(completer: UpdateCompleter) =
    update(this::update, MemberCredential, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: MemberCredentialRecord) =
    apply {
        set(memberCredentialId).equalTo(record::memberCredentialId)
        set(memberId).equalTo(record::memberId)
        set(loginId).equalTo(record::loginId)
        set(password).equalTo(record::password)
        set(createdAt).equalTo(record::createdAt)
        set(updatedAt).equalTo(record::updatedAt)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: MemberCredentialRecord) =
    apply {
        set(memberCredentialId).equalToWhenPresent(record::memberCredentialId)
        set(memberId).equalToWhenPresent(record::memberId)
        set(loginId).equalToWhenPresent(record::loginId)
        set(password).equalToWhenPresent(record::password)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(updatedAt).equalToWhenPresent(record::updatedAt)
    }

fun MemberCredentialMapper.updateByPrimaryKey(record: MemberCredentialRecord) =
    update {
        set(memberId).equalTo(record::memberId)
        set(loginId).equalTo(record::loginId)
        set(password).equalTo(record::password)
        set(createdAt).equalTo(record::createdAt)
        set(updatedAt).equalTo(record::updatedAt)
        where(memberCredentialId, isEqualTo(record::memberCredentialId))
    }

fun MemberCredentialMapper.updateByPrimaryKeySelective(record: MemberCredentialRecord) =
    update {
        set(memberId).equalToWhenPresent(record::memberId)
        set(loginId).equalToWhenPresent(record::loginId)
        set(password).equalToWhenPresent(record::password)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(updatedAt).equalToWhenPresent(record::updatedAt)
        where(memberCredentialId, isEqualTo(record::memberCredentialId))
    }
