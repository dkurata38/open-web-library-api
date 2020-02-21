package com.github.dkurata38.open_web_library.domain.member

import com.github.dkurata38.library.domain_lib.persistence.IdIssuer
import com.github.dkurata38.library.domain_lib.persistence.Identifier

data class MemberId(private val _value: String) : Identifier<MemberId> {
    companion object {
        private val idIssuer = IdIssuer { MemberId(it) }
        fun issue(): MemberId {
            return idIssuer.issue()
        }
    }

    override fun getType(): Class<MemberId> {
        return MemberId::class.java
    }

    override fun getValue(): String {
        return _value
    }
}
