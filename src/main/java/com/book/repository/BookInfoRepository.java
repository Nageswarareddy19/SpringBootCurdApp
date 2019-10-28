package com.book.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.entity.BookInfoEntity;

@Repository("bookInfoRepo")
public interface BookInfoRepository extends JpaRepository<BookInfoEntity,Serializable> {


	
}
