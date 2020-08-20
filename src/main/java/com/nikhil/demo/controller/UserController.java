package com.nikhil.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.demo.entity.Books;
import com.nikhil.demo.entity.User;
import com.nikhil.demo.entity.model.BooksModel;
import com.nikhil.demo.entity.model.UserModel;
import com.nikhil.demo.service.UserService;

@RestController
public class UserController {

	@Autowired private UserService userService;
	
	
	
	@GetMapping(value = "/getUser")
	public List<UserModel> findAllUser(){
		
		return userService.findAllUser();
	}
	

	@GetMapping("/getUser/{userName}") 
    
    public List<UserModel> findByUserName(@PathVariable String userName) {
   	 return userService.findByUserName(userName);
    }
	
	
	@PostMapping(value = "/saveUser")
	public UserModel saveUser(@RequestBody UserModel um) {
		
		
		return userService.saveUser(um);
	}
	
	
	@PutMapping(value = "/updateUser/{userId}")
	public UserModel updateUser(@PathVariable int userId,@RequestBody UserModel um) {
		
		return userService.updateUser(userId, um);
	}
	
	
	
	
	@PostMapping(value = "/assignToUser/{userId}/{bookId}")
	public String assignToUser(@PathVariable int userId,@PathVariable int bookId) {
		
		
		return userService.assignToUser(userId, bookId);
	}
	   
	@PostMapping(value = "returnBook/{userId}/{bookId}")
     	public String returnBook(@PathVariable int userId,@PathVariable int bookId) {
		
		
		return userService.returnBook(userId, bookId);
		
	}
     	
	
	
	
   
	
}
