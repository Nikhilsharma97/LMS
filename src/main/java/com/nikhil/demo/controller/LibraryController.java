package com.nikhil.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.demo.entity.Library;
import com.nikhil.demo.entity.model.LibraryModel;
import com.nikhil.demo.service.LibraryService;

@RestController
public class LibraryController {

	@Autowired private LibraryService libraryService;
	
	@GetMapping(value = "/getLib")
	public List<LibraryModel> findAllLibrary(){
		
		return libraryService.findAllLib();
	}
	
	
	@PostMapping(value = "/addLibrary")
	public LibraryModel saveLibrary(@RequestBody LibraryModel lm) {
		return libraryService.saveLibrary(lm);
	}
	
}
