package com.nikhil.demo.entity.model;

import java.util.List;

public class LibraryModel {
	

	private int libIsbn;
	private String libName;
	
	private List<String> shelves;

	public int getLibIsbn() {
		return libIsbn;
	}

	public void setLibIsbn(int libIsbn) {
		this.libIsbn = libIsbn;
	}

	public String getLibName() {
		return libName;
	}

	public void setLibName(String libName) {
		this.libName = libName;
	}

	public List<String> getShelves() {
		return shelves;
	}

	public void setShelves(List<String> shelves) {
		this.shelves = shelves;
	}

	@Override
	public String toString() {
		return "LibraryModel [libIsbn=" + libIsbn + ", libName=" + libName + ", shelves=" + shelves + "]";
	}
	
	
	

}
