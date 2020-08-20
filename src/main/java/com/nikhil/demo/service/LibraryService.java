package com.nikhil.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nikhil.demo.dao.LibraryRepo;
import com.nikhil.demo.entity.Library;
import com.nikhil.demo.entity.model.LibraryModel;

@Service
public class LibraryService {
	
	@Autowired private LibraryRepo libraryRepo;
	
	
	@Transactional public List<LibraryModel> findAllLib(){
		
		List<Library> libraryList=libraryRepo.findAll();
		List<LibraryModel> modelList=new ArrayList<>();
		for(Library l:libraryList) {
			LibraryModel l1=new LibraryModel();
			l1.setLibIsbn(l.getLibIsbn());
			l1.setLibName(l.getLibName());
			modelList.add(l1);
		}
		return modelList;
	}
	
	@Transactional public LibraryModel saveLibrary(LibraryModel lm){
		
		Library l=new Library();
		l.setLibIsbn(lm.getLibIsbn());
		l.setLibName(lm.getLibName());
		libraryRepo.save(l);
		return lm;
		
	}

}
