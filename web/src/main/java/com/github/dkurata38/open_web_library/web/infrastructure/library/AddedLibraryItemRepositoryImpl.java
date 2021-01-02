package com.github.dkurata38.open_web_library.web.infrastructure.library;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItem;
import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItemId;
import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItemRepository;
import com.github.dkurata38.open_web_library.library_domain.OwnerId;

@Repository
public class AddedLibraryItemRepositoryImpl implements AddedLibraryItemRepository {
	private final AddedLibraryItemMapper addedLibraryItemMapper;

	public AddedLibraryItemRepositoryImpl(AddedLibraryItemMapper addedLibraryItemMapper) {
		this.addedLibraryItemMapper = addedLibraryItemMapper;
	}

	@Override
	public AddedLibraryItem findById(AddedLibraryItemId id) {
		return addedLibraryItemMapper.selectById(id);
	}

	@Override
	public List<AddedLibraryItem> findByOwnerId(OwnerId ownerId) {
		return addedLibraryItemMapper.selectAllBy(ownerId);
	}

	@Override
	public void save(AddedLibraryItem addedLibraryItem) {
		addedLibraryItemMapper.insert(addedLibraryItem);
	}
}
