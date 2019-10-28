package com.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.BookInfoEntity;
import com.book.model.BookInfoModel;
import com.book.repository.BookInfoRepository;

@Service("bookInfoService")
public class BookInfoServiceImpl implements BookInfoService {

	@Autowired
	private BookInfoRepository bookInfoRepo;

	@Override
	public boolean insertBook(BookInfoModel model) {
		BookInfoEntity entity = new BookInfoEntity();
		BeanUtils.copyProperties(model, entity);
		BookInfoEntity be = bookInfoRepo.save(entity);
		if (be.getBookId() != 0)
			return true;
		else
			return false;

	}

	@Override
	public List<BookInfoModel> findAllBooks() {

		List<BookInfoEntity> bookInfoEntities = bookInfoRepo.findAll();

		List<BookInfoModel> bookList = new ArrayList<>();

		for (BookInfoEntity enity : bookInfoEntities) {

			BookInfoModel model = new BookInfoModel();
			// Converting entity to model
			BeanUtils.copyProperties(enity, model);
			bookList.add(model);
		}

		return bookList;
	}

	@Override
	public boolean deleteBook(int id) {
		Optional<BookInfoEntity> opt = null;
		bookInfoRepo.deleteById(id);
		opt = bookInfoRepo.findById(id);
		if (opt.isPresent())
			return true;
		else
			return false;
	}

	@Override
	public BookInfoModel editBook(int bookId) {
		BookInfoEntity entity = bookInfoRepo.findById(bookId).orElse(null);
		BookInfoModel model = new BookInfoModel();
		BeanUtils.copyProperties(entity, model);
		return model;
	}

	@Override
	public boolean updateBook(BookInfoModel model) {
		Optional<BookInfoEntity> Optionalentity = bookInfoRepo.findById(model.getBookId());
		BookInfoEntity entity=Optionalentity.get();
		//entity.setBookId(model.getBookId());
		entity.setBookName(model.getBookName());
		entity.setBookPrice(model.getBookPrice());
		entity.setAuthor(model.getAuthor());
		BookInfoEntity be = bookInfoRepo.save(entity);
		if (be != null)
			return true;
		else
			return false;

	}

}
