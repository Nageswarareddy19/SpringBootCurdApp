package com.book.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.book.constants.AppConstants;
import com.book.model.BookInfoModel;
import com.book.properties.AppProperties;
import com.book.service.BookInfoService;

@Controller
public class BookInfoController {
	
	@Autowired(required = true)
	private AppProperties prop;
	
	@Autowired
	
	private BookInfoService service;

	/*
	 * @ModelAttribute("book") public BookInfoModel bookForm() { return new
	 * BookInfoModel(); }
	 */

	@RequestMapping(value = { "/", "/dispBook" }, method = RequestMethod.GET)
	public String dispBookForm(Model model) {

		model.addAttribute(AppConstants.BOOK, new BookInfoModel());
		return AppConstants.BOOK_FORM;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveBook(Model model, @ModelAttribute("book") @Valid BookInfoModel books, BindingResult bindingResult,
			RedirectAttributes rta) {

		if (bindingResult.hasErrors())
			return AppConstants.BOOK_FORM;
		boolean isInsert = service.insertBook(books);
		if (isInsert) {
			String successMsg=prop.getProps().get("smsg");
			rta.addFlashAttribute("smsg", successMsg);

		} else {
			String failMsg=prop.getProps().get("fmsg");
			rta.addFlashAttribute("fmsg", failMsg);

		}

		model.addAttribute(AppConstants.BOOK_FORM, new BookInfoModel());
		return  AppConstants.REDIRECT_SUCC;
	}

	@GetMapping("/successurl")
	public String success(Model model) {
		BookInfoModel b = new BookInfoModel();

		model.addAttribute(AppConstants.BOOK, b);
		return AppConstants.BOOK_FORM;
	}

	@RequestMapping("/retrieveBooks")
	public String viewBooks(Model model) {

		List<BookInfoModel> booksList = service.findAllBooks();
		model.addAttribute("bookinfo", booksList);
		return AppConstants.VIEW_BOOKS;

	}

	@RequestMapping(value = "/deletebook/{bookId}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable int bookId, Model model) {

		boolean isDeleted = service.deleteBook(bookId);
		String  deleteMsg=prop.getProps().get("sMsg");
		String unDeleteMsg=prop.getProps().get("eMsg");
		if (isDeleted)
		
			model.addAttribute("sMsg", deleteMsg);
		else
			model.addAttribute("eMsg", unDeleteMsg);

		return AppConstants.REDIRECT_VIEWBOOKS;

	}

	@RequestMapping(value = "/editbook/{bookId}", method = RequestMethod.GET)
	public String editBook(@PathVariable int bookId, Model model) {

		BookInfoModel bookModel = service.editBook(bookId);
		model.addAttribute(AppConstants.BOOK, bookModel);

		return AppConstants.EDIT_BOOK;

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateBook(Model model, @ModelAttribute("book") @Valid BookInfoModel modelbook,
			BindingResult bindingResult,RedirectAttributes rda) {

		if (bindingResult.hasErrors())
			return AppConstants.EDIT_BOOK;
		boolean isUpdated = service.updateBook(modelbook);
		String updateSuccess=prop.getProps().get("upSuc");
		String unUpdateMsg=prop.getProps().get("upUnSuc");
		if (isUpdated)
			rda.addFlashAttribute("upSuc", updateSuccess);
		else
			rda.addFlashAttribute("upUnSuc", unUpdateMsg);

		model.addAttribute(AppConstants.BOOK, new BookInfoModel());
		return AppConstants.REDIRECT__EDIT_SUCCESS;
	}

	@GetMapping("/editsuccessurl")
	public String editSuccess(Model model) {
		BookInfoModel b = new BookInfoModel();

		model.addAttribute(AppConstants.BOOK, b);
		return AppConstants.EDIT_BOOK;
	}

}
