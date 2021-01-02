package com.github.dkurata38.open_web_library.web.infrastructure.library;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.github.dkurata38.open_web_library.library_domain.Book;
import com.github.dkurata38.open_web_library.library_domain.BookId;
import com.github.dkurata38.open_web_library.library_domain.Isbn13;

@Mapper
public interface BookMapper {
	Book selectById(@Param("id") BookId id);
	Book selectByIsbn13(@Param("isbn13") Isbn13 isbn13);
	List<Book> selectAllBy(@Param("ids") List<BookId> ids);
	void insert(Book book);
	void updateById(Book book);
}
