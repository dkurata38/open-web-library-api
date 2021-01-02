package com.github.dkurata38.open_web_library.web.infrastructure.library;

import com.github.dkurata38.open_web_library.library_domain.LibraryItemId;
import com.github.dkurata38.open_web_library.web.infrastructure.common.StringValueTypeHandler;

public class LibraryItemIdTypeHandler extends StringValueTypeHandler<LibraryItemId> {
	public LibraryItemIdTypeHandler() {
		super(LibraryItemId::getValue, LibraryItemId::new);
	}
}
