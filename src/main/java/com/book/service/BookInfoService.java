package com.book.service;

import java.util.List;



import com.book.model.BookInfoModel;


public interface BookInfoService {

		public boolean insertBook(BookInfoModel model);
		public List<BookInfoModel> findAllBooks();
		public boolean deleteBook(int id);
		
		public BookInfoModel editBook(int bookId);
		public boolean updateBook(BookInfoModel model);
	
		
}
