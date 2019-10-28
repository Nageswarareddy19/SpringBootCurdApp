package com.book.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BookInfoModel {
	
	
	private int bookId;
	@NotEmpty(message = "Please Provide Book Name")
	private String bookName;
	@NotNull(message = "Please Provide Book Price")
	private Double bookPrice;
	@NotEmpty(message = "Please Provide Book Author Name")
	private String author;

}
