package com.github.dkurata38.open_web_library.web.infrastructure.library;

import com.github.dkurata38.open_web_library.library_domain.OwnerId;
import com.github.dkurata38.open_web_library.web.infrastructure.common.StringValueTypeHandler;

public class OwnerIdTypeHandler extends StringValueTypeHandler<OwnerId> {
	public OwnerIdTypeHandler() {
		super(OwnerId::getValue, OwnerId::new);
	}
}
