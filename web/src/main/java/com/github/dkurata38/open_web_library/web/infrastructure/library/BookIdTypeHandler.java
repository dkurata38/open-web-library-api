package com.github.dkurata38.open_web_library.web.infrastructure.library;

import com.github.dkurata38.open_web_library.library_domain.BookId;
import com.github.dkurata38.open_web_library.web.infrastructure.common.StringValueTypeHandler;

public class BookIdTypeHandler extends StringValueTypeHandler<BookId> {
	public BookIdTypeHandler() {
		super(BookId::getValue, BookId::new);
	}
}
