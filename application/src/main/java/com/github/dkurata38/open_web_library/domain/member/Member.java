package com.github.dkurata38.open_web_library.domain.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static java.util.stream.Collectors.*;

@RequiredArgsConstructor
public class Member {
	@NotNull
	@Getter
	private final MemberId memberId;
	@NotEmpty
	@Getter
	private final String name;
}
