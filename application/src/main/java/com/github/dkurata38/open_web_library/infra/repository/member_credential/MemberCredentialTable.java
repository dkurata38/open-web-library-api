package com.github.dkurata38.open_web_library.infra.repository.member_credential;

import java.time.LocalDateTime;
import javax.annotation.Generated;

public class MemberCredentialTable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.member_credential_id")
    private String memberCredentialId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.member_id")
    private String memberId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.login_id")
    private String loginId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.password")
    private String password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.created_at")
    private LocalDateTime createdAt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.updated_at")
    private LocalDateTime updatedAt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.member_credential_id")
    public String getMemberCredentialId() {
        return memberCredentialId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.member_credential_id")
    public void setMemberCredentialId(String memberCredentialId) {
        this.memberCredentialId = memberCredentialId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.member_id")
    public String getMemberId() {
        return memberId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.member_id")
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.login_id")
    public String getLoginId() {
        return loginId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.login_id")
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.password")
    public String getPassword() {
        return password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.password")
    public void setPassword(String password) {
        this.password = password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.created_at")
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.created_at")
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.updated_at")
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: member_credential.updated_at")
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
