package com.nikhil.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nikhil.demo.dao.LibraryRepo;
import com.nikhil.demo.dao.ShelvesRepo;
import com.nikhil.demo.entity.Books;
import com.nikhil.demo.entity.Library;
import com.nikhil.demo.entity.Shelves;
import com.nikhil.demo.entity.model.BooksModel;
import com.nikhil.demo.entity.model.ShelveModel;


@Service
public class ShelvesService {

	@Autowired private ShelvesRepo shelveRepo;
	@Autowired private LibraryRepo libraryRepo;
	
     //////  get //

	@Transactional public List<ShelveModel> findAllShelves(){
		 List<Shelves> shelveList=shelveRepo.findAll();
		 List<ShelveModel>modelList=new ArrayList<>();
		 for( Shelves s:shelveList) {
			ShelveModel s1=new ShelveModel();
			 s1.setShelveId(s.getShelveId());
			 s1.setsName(s.getsName());
			 s1.setBookCount(s.getBookCount());
			 modelList.add(s1);
			 
		     }
		         return modelList;
	                       }


		
	

    //////serach/////
	@Transactional public List<ShelveModel> findBysName( String sName){
		 List<Shelves> shelveList=shelveRepo.findBysName(sName);
		 List<ShelveModel>modelList=new ArrayList<>();
		 for( Shelves s:shelveList) {
			ShelveModel s1=new ShelveModel();
			 s1.setShelveId(s.getShelveId());
			 s1.setBookCount(s.getBookCount());
			 s1.setsName(s.getsName());
			 modelList.add(s1);
			 
		     }
		         return modelList;
	}
	
	

	/////create/////

	@Transactional public ShelveModel saveShelve(ShelveModel sm , int libIsbn) {
		Library lb=libraryRepo.getOne(libIsbn);
		Shelves s=new Shelves();
		s.setsName(sm.getsName());
		int count=sm.getBookCount();
		s.setBookCount(count);
		
		shelveRepo.save(s);
		lb.getShelve().add(s);
		libraryRepo.save(lb);
	   return sm;
	}
	
	public String addShelveToLib(int shelveId, int libIsbn) {
		Shelves sh=shelveRepo.getOne(shelveId);
		Library lb=libraryRepo.getOne(libIsbn);
		List<Shelves>ss=new ArrayList<>();
		ss.add(sh);
		lb.setShelve(ss);;
		
		shelveRepo.save(sh);
		libraryRepo.save(lb);
			
		return"added";
		
	}
	




	
	
	
	
}
