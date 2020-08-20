package com.nikhil.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.demo.entity.Library;

public interface LibraryRepo extends JpaRepository<Library, Integer>{
	

}
