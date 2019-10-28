package com.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="BOOK_INFO")
public class BookInfoEntity {
	
	@Id
	@GeneratedValue
	@Column(name="BOOK_ID")
	private int bookId;
	
	@Column(name="BOOK_NAME")
	private String  bookName;
	
	@Column(name="BOOK_PRICE")
	private Double bookPrice;
	
	@Column(name="AUTHOR")
	private String author;
	

}
