package com.github.dkurata38.open_web_library.common;

import static java.util.stream.Collectors.*;

public interface Identifier<T> {
	Class<T> getType();
	String getValue();
}
