package com.github.dkurata38.open_web_library.infra.repository.member_credential;

import static com.github.dkurata38.open_web_library.infra.repository.member_credential.MemberCredentialTableDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import java.util.List;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

@Mapper
public interface MemberCredentialTableMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: member_credential")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: member_credential")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<MemberCredentialTable> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: member_credential")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("MemberCredentialTableResult")
    MemberCredentialTable selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: member_credential")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MemberCredentialTableResult", value = {
        @Result(column="member_credential_id", property="memberCredentialId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="member_id", property="memberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_id", property="loginId", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<MemberCredentialTable> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: member_credential")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: member_credential")
    default int deleteByPrimaryKey(String memberCredentialId_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, memberCredentialTable)
                .where(memberCredentialId, isEqualTo(memberCredentialId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: member_credential")
    default int insert(MemberCredentialTable record) {
        return insert(SqlBuilder.insert(record)
                .into(memberCredentialTable)
                .map(memberCredentialId).toProperty("memberCredentialId")
                .map(memberId).toProperty("memberId")
                .map(loginId).toProperty("loginId")
                .map(password).toProperty("password")
                .map(createdAt).toProperty("createdAt")
                .map(updatedAt).toProperty("updatedAt")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: member_credential")
    default int insertSelective(MemberCredentialTable record) {
        return insert(SqlBuilder.insert(record)
                .into(memberCredentialTable)
                .map(memberCredentialId).toPropertyWhenPresent("memberCredentialId", record::getMemberCredentialId)
                .map(memberId).toPropertyWhenPresent("memberId", record::getMemberId)
                .map(loginId).toPropertyWhenPresent("loginId", record::getLoginId)
                .map(password).toPropertyWhenPresent("password", record::getPassword)
                .map(createdAt).toPropertyWhenPresent("createdAt", record::getCreatedAt)
                .map(updatedAt).toPropertyWhenPresent("updatedAt", record::getUpdatedAt)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: member_credential")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<MemberCredentialTable>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, memberCredentialId, memberId, loginId, password, createdAt, updatedAt)
                .from(memberCredentialTable);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: member_credential")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<MemberCredentialTable>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, memberCredentialId, memberId, loginId, password, createdAt, updatedAt)
                .from(memberCredentialTable);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: member_credential")
    default MemberCredentialTable selectByPrimaryKey(String memberCredentialId_) {
        return SelectDSL.selectWithMapper(this::selectOne, memberCredentialId, memberId, loginId, password, createdAt, updatedAt)
                .from(memberCredentialTable)
                .where(memberCredentialId, isEqualTo(memberCredentialId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: member_credential")
    default int updateByPrimaryKey(MemberCredentialTable record) {
        return UpdateDSL.updateWithMapper(this::update, memberCredentialTable)
                .set(memberId).equalTo(record::getMemberId)
                .set(loginId).equalTo(record::getLoginId)
                .set(password).equalTo(record::getPassword)
                .set(createdAt).equalTo(record::getCreatedAt)
                .set(updatedAt).equalTo(record::getUpdatedAt)
                .where(memberCredentialId, isEqualTo(record::getMemberCredentialId))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: member_credential")
    default int updateByPrimaryKeySelective(MemberCredentialTable record) {
        return UpdateDSL.updateWithMapper(this::update, memberCredentialTable)
                .set(memberId).equalToWhenPresent(record::getMemberId)
                .set(loginId).equalToWhenPresent(record::getLoginId)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(createdAt).equalToWhenPresent(record::getCreatedAt)
                .set(updatedAt).equalToWhenPresent(record::getUpdatedAt)
                .where(memberCredentialId, isEqualTo(record::getMemberCredentialId))
                .build()
                .execute();
    }
}
