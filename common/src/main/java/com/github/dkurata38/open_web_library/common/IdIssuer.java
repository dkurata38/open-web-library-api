package com.github.dkurata38.open_web_library.common;

import lombok.RequiredArgsConstructor;

import java.util.UUID;
import java.util.function.Function;

@RequiredArgsConstructor
public class IdIssuer<T extends Identifier<T>> {
	private final Function<String, T> constructor;

	public T issue() {
		return constructor.apply(UUID.randomUUID().toString());
	}
}
