package com.github.dkurata38.open_web_library.web.infrastructure.library;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItem;
import com.github.dkurata38.open_web_library.library_domain.AddedLibraryItemId;
import com.github.dkurata38.open_web_library.library_domain.OwnerId;

@Mapper
public interface AddedLibraryItemMapper {
	List<AddedLibraryItem> selectAllBy(@Param("ownerId") OwnerId ownerId);
	AddedLibraryItem selectById(@Param("id") AddedLibraryItemId id);
	void insert(AddedLibraryItem addedLibraryItem);
}
