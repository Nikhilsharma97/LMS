package com.nikhil.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.demo.entity.Shelves;
import com.nikhil.demo.entity.model.ShelveModel;
import com.nikhil.demo.service.ShelvesService;

@RestController
public class ShelvesController {

	
	@Autowired private ShelvesService shelveService;
	
	
	@GetMapping(value = "/getAllShelves")
	public List<ShelveModel> findAllShelve(){
		
		return shelveService.findAllShelves();
	}
	

	@GetMapping("/getShelve/{sName}") 
    public List<ShelveModel> findBysName(@PathVariable String sName) {
   	
		return shelveService.findBysName(sName);
    
	}
	
	@PostMapping(value = "/saveShelve")
	public ShelveModel saveShelves(@RequestBody ShelveModel sm) {
		
		return shelveService.saveShelve(sm,1);
	}
	

		
}
