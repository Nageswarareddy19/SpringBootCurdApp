package com.book.constants;

public class AppConstants {

	//Specify the model attribute
	public static final String BOOK="book";
	//specify the bookForm view name
	public static final String BOOK_FORM="bookForm";
	//specify the editBook view Name
	public static final String 	EDIT_BOOK="editBook";
	//specify the viewBooks view Name
	public static final String VIEW_BOOKS="viewBooks";
	//as part of Post Redirect get design pattern  redirect the url in saveBook() method
	public static final String  REDIRECT_SUCC="redirect:successurl";
	//after deleting the record page should navigate to view books with the help of /retrieveBooks
	public static final String REDIRECT_VIEWBOOKS="redirect:/retrieveBooks";
	//after editing the record  the navigation should go to the editBook form with the help of url is /editsuccessurl
	public static final String  REDIRECT__EDIT_SUCCESS="redirect:editsuccessurl";
	
}
