package com.nikhil.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nikhil.demo.dao.BookRepo;
import com.nikhil.demo.dao.ShelvesRepo;
import com.nikhil.demo.entity.Books;
import com.nikhil.demo.entity.Shelves;
import com.nikhil.demo.entity.model.BooksModel;

@Service	
public class BookService {
	
	@Autowired private  BookRepo bookRepo;
	@Autowired private  ShelvesRepo shelveRepo;
	
  
	////////////get list of books by page and sort ////////
	@Transactional public List<BooksModel> findAllBooksBypage(Pageable page){
		 
		 Page<Books> bookList=bookRepo.findAll(page);
		 List<BooksModel>modelList=new ArrayList<>();
		 for( Books b:bookList) {
			 BooksModel b1=new BooksModel();
			 b1.setBookId(b.getBookId());
			 b1.setAuthor(b.getAuthor());
			 b1.setBookName(b.getBookName());
			 b1.setCurrentStatus(b.getCurrentStatus());
			 modelList.add(b1);
			 
		 }
	return modelList;
		}
	
	
	      //////  get //
	 @Transactional public List<BooksModel> findAllBooks(){
		 
		 List<Books> bookList=bookRepo.findAll();
		 List<BooksModel>modelList=new ArrayList<>();
		 for( Books b:bookList) {
			 BooksModel b1=new BooksModel();
			 b1.setBookId(b.getBookId());
			 b1.setAuthor(b.getAuthor());
			 b1.setBookName(b.getBookName());
			 b1.setCurrentStatus(b.getCurrentStatus());
			 modelList.add(b1);
			 
		 }
	return modelList;
		}
	
	      //////serach/////

	 @Transactional public List<BooksModel> findBYName(String bookName){
		 
		 List<Books> bookList=bookRepo.findByBookName(bookName);
		 List<BooksModel>modelList=new ArrayList<>();
		 for( Books b:bookList) {
			 BooksModel b1=new BooksModel();
			 b1.setBookId(b.getBookId());
			 b1.setAuthor(b.getAuthor());
			 b1.setBookName(b.getBookName());
			 b1.setCurrentStatus(b.getCurrentStatus());
			 modelList.add(b1);
			 
		 }
	return modelList;
		}
	
		
		
	 /////create/////
	@Transactional public Books saveBook(BooksModel bm) {
		 
		Books b=new Books();
		b.setBookId(bm.getBookId());
		b.setAuthor(bm.getAuthor());
		b.setBookName(bm.getBookName());
		b.setCurrentStatus(bm.getCurrentStatus());
		
		bookRepo.save(b);
		   return b;
     	}
	
	
	public String addBookToShelve(int bookId, int shelveId) {
		 Books bk=bookRepo.getOne(bookId);
		Shelves sh=shelveRepo.getOne(shelveId);
		List<Books>bs=new ArrayList<>();
		sh.setBookCount(sh.getBookCount()+1);
		bs.add(bk);
		sh.setBook(bs);
		bk.setShelve(sh);
		shelveRepo.save(sh);
		bookRepo.save(bk);
			
		return"added";
		
	}
	
	
	///////update////
	@Transactional public BooksModel updateBook(int bookId,BooksModel bm) {
		
		Books b=bookRepo.getOne(bookId);
		
		b.setAuthor(bm.getAuthor());
		b.setBookName(bm.getBookName());
		b.setCurrentStatus(bm.getCurrentStatus());
		bookRepo.save(b);

		   return bm;
    }
	
	
//	 //////////delete /////
//	@Transactional public String deleteBook(int bookId) {
//		
//		Books b=bookRepo.getOne(bookId);
//		
//		
//		   bookRepo.deleteById(bookId);
//		}
//
	  	
}
