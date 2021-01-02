package com.github.dkurata38.open_web_library.member_domain

import java.util.*

object IdIssuer {
	fun generateIdValue(): String {
		return UUID.randomUUID().toString()
	}
}
