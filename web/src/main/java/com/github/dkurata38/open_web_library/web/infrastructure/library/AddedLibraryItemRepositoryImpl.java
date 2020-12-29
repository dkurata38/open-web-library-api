package com.github.dkurata38.open_web_library.web.infrastructure.library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItem;
import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItemId;
import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItemRepository;
import com.github.dkurata38.open_web_library.library_domain.OwnerId;

@Repository
public class AddedLibraryItemRepositoryImpl implements AddedLibraryItemRepository {
	private List<AddedLibraryItem> values = new ArrayList<>();
	@Override
	public AddedLibraryItem findById(AddedLibraryItemId id) {
		return values
				.stream()
				.filter(e -> e.getId() == id)
				.findFirst()
				.orElse(null);
	}

	@Override
	public List<AddedLibraryItem> findByOwnerId(OwnerId ownerId) {
		return values
				.stream()
				.filter(e -> e.getOwnerId() == ownerId)
				.collect(Collectors.toList());
	}

	@Override
	public void save(AddedLibraryItem addedLibraryItem) {
		values.add(addedLibraryItem);
	}
}
