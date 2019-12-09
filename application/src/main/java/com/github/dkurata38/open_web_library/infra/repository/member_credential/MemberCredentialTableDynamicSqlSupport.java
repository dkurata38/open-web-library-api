package com.github.dkurata38.open_web_library.infra.repository.member_credential;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class MemberCredentialTableDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: member_credential")
    public static final MemberCredentialTable memberCredentialTable = new MemberCredentialTable();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.member_credential_id")
    public static final SqlColumn<String> memberCredentialId = memberCredentialTable.memberCredentialId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.member_id")
    public static final SqlColumn<String> memberId = memberCredentialTable.memberId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.login_id")
    public static final SqlColumn<String> loginId = memberCredentialTable.loginId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.password")
    public static final SqlColumn<String> password = memberCredentialTable.password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.created_at")
    public static final SqlColumn<LocalDateTime> createdAt = memberCredentialTable.createdAt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.updated_at")
    public static final SqlColumn<LocalDateTime> updatedAt = memberCredentialTable.updatedAt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: member_credential")
    public static final class MemberCredentialTable extends SqlTable {
        public final SqlColumn<String> memberCredentialId = column("member_credential_id", JDBCType.VARCHAR);

        public final SqlColumn<String> memberId = column("member_id", JDBCType.VARCHAR);

        public final SqlColumn<String> loginId = column("login_id", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createdAt = column("created_at", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updatedAt = column("updated_at", JDBCType.TIMESTAMP);

        public MemberCredentialTable() {
            super("member_credential");
        }
    }
}
