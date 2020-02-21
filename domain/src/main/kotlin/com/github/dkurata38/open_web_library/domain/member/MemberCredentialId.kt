package com.github.dkurata38.open_web_library.domain.member

import com.github.dkurata38.library.domain_lib.persistence.IdIssuer
import com.github.dkurata38.library.domain_lib.persistence.Identifier

class MemberCredentialId(private val _value: String) : Identifier<MemberCredentialId> {

    companion object {
        private val idIssuer = IdIssuer { MemberCredentialId(it) }
        fun issue(): MemberCredentialId {
            return idIssuer.issue()
        }
    }


    override fun getType(): Class<MemberCredentialId> {
        return javaClass
    }

    override fun getValue(): String {
        return _value
    }
}
