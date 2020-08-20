package com.nikhil.demo.dao;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nikhil.demo.entity.Books;


@Repository
public interface BookRepo extends JpaRepository<Books, Integer>{
	
	List<Books> findByBookName(String bookName);
//	List<Books> findByBookName(String bookName,Pageable page);
	

}
