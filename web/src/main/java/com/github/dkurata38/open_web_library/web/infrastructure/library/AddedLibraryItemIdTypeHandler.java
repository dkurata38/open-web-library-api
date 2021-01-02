package com.github.dkurata38.open_web_library.web.infrastructure.library;

import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItemId;
import com.github.dkurata38.open_web_library.web.infrastructure.common.StringValueTypeHandler;

public class AddedLibraryItemIdTypeHandler extends StringValueTypeHandler<AddedLibraryItemId> {
	public AddedLibraryItemIdTypeHandler() {
		super(AddedLibraryItemId::getValue, AddedLibraryItemId::new);
	}
}
