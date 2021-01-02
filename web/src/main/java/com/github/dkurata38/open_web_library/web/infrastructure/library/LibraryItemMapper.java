package com.github.dkurata38.open_web_library.web.infrastructure.library;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.github.dkurata38.open_web_library.library_domain.LibraryItem;
import com.github.dkurata38.open_web_library.library_domain.LibraryItemId;
import com.github.dkurata38.open_web_library.library_domain.OwnerId;

@Mapper
public interface LibraryItemMapper {
	List<LibraryItem> selectByOwnerId(@Param("ownerId") OwnerId ownerId);
	LibraryItem selectById(@Param("id") LibraryItemId id);
}
