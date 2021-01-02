package com.github.dkurata38.open_web_library.web.infrastructure.library;

import com.github.dkurata38.open_web_library.library_domain.Isbn13;
import com.github.dkurata38.open_web_library.web.infrastructure.common.StringValueTypeHandler;

public class Isbn13TypeHandler extends StringValueTypeHandler<Isbn13> {
	public Isbn13TypeHandler() {
		super(Isbn13::getValue, Isbn13::new);
	}
}
