package com.nikhil.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.demo.entity.Books;
import com.nikhil.demo.entity.model.BooksModel;
import com.nikhil.demo.service.BookService;


@RestController

public class BooksController {

	@Autowired private BookService bookService;
	
	@GetMapping(value = "/getByPage")
	public List<BooksModel> findAllBooksBypage(Pageable page){
		return bookService.findAllBooksBypage(page);
	}
	
	@GetMapping(value = "/getAll")
	public List<BooksModel> findAllBooks(){
		return bookService.findAllBooks();
	}

	
	@GetMapping("/getBook/{bookName}") 
    
    public List<BooksModel> findByBookName(@PathVariable String bookName) {
   	 return bookService.findBYName(bookName);
    }
   
	@PostMapping(value = "/saveBook")
	public Books saveBook(@RequestBody BooksModel bm) {
		return bookService.saveBook(bm);
		
	}
	
	
	@PutMapping(value = "/updateBook/{bookId}")
	public BooksModel updateBook(@PathVariable int bookId,@RequestBody BooksModel bm) {
		
		return bookService.updateBook(bookId, bm);
	}
	
	
	@PostMapping(value = "/addBookShelve/{bookId}/{shelveId}")
		public String addBookToShelve(@PathVariable int bookId,@PathVariable int shelveId) {
			
			 return bookService.addBookToShelve(bookId, shelveId);
		
	
	}
	
	
//     when u want to search by page and sort method//
//	@GetMapping("/getBook/{bookName}/{page}/{size}") 
//    
//    public List<BooksModel> findByBookName(@PathVariable String bookName,@PathVariable int page,@PathVariable int size) {
//		Pageable pageing= PageRequest.of(page,size);
//   	 return bookService.findBYName(bookName,pageing);
//    }
	
	
	
		
//	@DeleteMapping(value = "deleteBook")
//	  public String deleteBook(@RequestParam int bookId) {
//		
//		return bookService.;
//	}
//	
}
