package com.github.dkurata38.open_web_library.web.infrastructure.library;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.github.dkurata38.open_web_library.library_domain.LibraryItem;
import com.github.dkurata38.open_web_library.library_domain.LibraryItemId;
import com.github.dkurata38.open_web_library.library_domain.LibraryItemRepository;
import com.github.dkurata38.open_web_library.library_domain.OwnerId;

@Repository
public class LibraryItemRepositoryImpl implements LibraryItemRepository {
	private final LibraryItemMapper libraryItemMapper;

	public LibraryItemRepositoryImpl(LibraryItemMapper libraryItemMapper) {
		this.libraryItemMapper = libraryItemMapper;
	}

	@Override
	public List<LibraryItem> findByOwnerId(OwnerId ownerId){
		return libraryItemMapper.selectByOwnerId(ownerId);
	}

	@Override
	public LibraryItem findById(LibraryItemId id) {
		return libraryItemMapper.selectById(id);
	}
}
