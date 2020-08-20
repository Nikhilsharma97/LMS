package com.nikhil.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.demo.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	List<User> findByUserName(String userName);
	
}
