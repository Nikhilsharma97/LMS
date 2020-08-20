package com.nikhil.demo.service;


import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nikhil.demo.dao.BookRepo;
import com.nikhil.demo.dao.ShelvesRepo;
import com.nikhil.demo.dao.UserRepo;
import com.nikhil.demo.entity.Books;
import com.nikhil.demo.entity.Shelves;
import com.nikhil.demo.entity.User;
import com.nikhil.demo.entity.model.BooksModel;
import com.nikhil.demo.entity.model.ShelveModel;
import com.nikhil.demo.entity.model.UserModel;


@Service
public class UserService {

	
	@Autowired private UserRepo userRapo;
	@Autowired private ShelvesRepo shelveRepo;
	
	@Autowired private BookRepo bookRepo;
	
  
	  //////  get //
	 @Transactional public List<UserModel> findAllUser(){
		 List<User> userList=userRapo.findAll();
		 List<UserModel>modelList=new ArrayList<>();
		 for( User u:userList) {
			UserModel u1=new UserModel();
			 u1.setUserId(u.getUserId());
			 u1.setUserName(u.getuserName());
			 u1.setPhoneNo(u.getPhoneNo());
			 modelList.add(u1);
			 
		     }
		         return modelList;

	 
	 
	 }
	
	      //////serach/////
		@Transactional public List<UserModel> findByUserName( String userName){
			
			List<User> userList=userRapo.findByUserName(userName);
			 List<UserModel>modelList=new ArrayList<>();
			 for( User u:userList) {
				UserModel u1=new UserModel();
				 u1.setUserId(u.getUserId());
				 u1.setUserName(u.getuserName());
				 u1.setPhoneNo(u.getPhoneNo());
				 modelList.add(u1);
				 
			     }
			         return modelList;
			
			}
		
		
	 /////create/////
	@Transactional public UserModel saveUser(UserModel um) {
		
		User u=new User();
		u.setUserId(um.getUserId());
		u.setuserName(um.getUserName());
		u.setPhoneNo(um.getPhoneNo());
		
		userRapo.save(u);
		
		return um;
		
		
    	}
	
	
	////////uddate///////
	
	@Transactional public UserModel updateUser(int userId,UserModel um){
		
		User u=userRapo.getOne(userId);
		u.setuserName(um.getUserName());
		u.setPhoneNo(um.getPhoneNo());
		
		userRapo.save(u);
		return um;
	}
		
	
	
  
	  ///////////////   assign to user ////////////////// 
	
   	public String assignToUser( int userId, int bookId) {
		Books book =bookRepo.findById(bookId).orElse(null);
		User user =userRapo.findById(userId).orElse(null);
		
		List<Books>bookList=user.getBook();
		
		if(book.getShelve()!=null) {
			
			if(book.getCurrentStatus().equalsIgnoreCase("available")) {
		
				bookList.add(book);
				book.setCurrentStatus("not ");
				bookRepo.save(book);
				
				int count=book.getShelve().getBookCount();
				book.getShelve().setBookCount((count-1));
				shelveRepo.save(book.getShelve());

				return "assigned"; 	
			}
			else {
				return "cant be assign";
			}
			
	 }
		else {
			   return "cant be assign shelve is not present";
			}
		}
   	
   	
   	
   	////// returing a book/////////
   	
//   	public String returnBook1(int userId,int bookId) {
//   		List<User> us=userRapo.findAll();
//   		User u = new User();
//   		for(User u1 :us) {
//   			if(u1.getUserId()==userId) {
//   				u=u1;
//   			}
//   		}
//   		List<Books>book=u.getBook();
//   		for(Books b :book) {
//   		
//   			          if(b.getBookId()==bookId) {
//   				
////   				if(b.getCurrentStatus().equalsIgnoreCase("not")) {
//   			   		Shelves sh= b.getShelve();
//   			   		int count=sh.getBookCount()+1;
//   			   		sh.setBookCount(count);
//   			   	    b.setCurrentStatus("available");
//   			   	    u.getBook().remove(b);
//   			   	    userRapo.save(u);
//   			   	    bookRepo.save(b);
//   			          }
//   		      else {
//   			        return"book is not issued to that user";	
//   		          }  
//   		
//   		}
//   		return "book returned";
//   	}

   	
   	public String returnBook(int userId,int bookId) {
   		 User u=userRapo.findById(userId).orElse(null);
   		List<Books>bookList=u.getBook();
   		Books bob=new Books();
   		
   		for(Books b:bookList) {
   			if(b.getBookId()==bookId) {
   				bob=b;
   				Shelves sh= b.getShelve();
			   		int count=sh.getBookCount()+1;
			   		sh.setBookCount(count);
			   	    b.setCurrentStatus("available");
			   	    
			   	 bookRepo.save(bob);
   				   			}
   			else {
   				return"book cant return as cant assign to that user";
   			}
   		}
   		u.getBook().remove(bob);
   		    userRapo.save(u);
			

   		return "book return";
   		
   	}
   	
   	
	
	
}
