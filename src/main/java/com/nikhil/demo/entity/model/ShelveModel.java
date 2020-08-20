package com.nikhil.demo.entity.model;

import java.util.List;

public class ShelveModel {

	private int shelveId;
	private String sName;
	private int BookCount;
	
	private List<String> books;

	public int getShelveId() {
		return shelveId;
	}

	public void setShelveId(int shelveId) {
		this.shelveId = shelveId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getBookCount() {
		return BookCount;
	}

	public void setBookCount(int bookCount) {
		BookCount = bookCount;
	}

	public List<String> getBooks() {
		return books;
	}

	public void setBooks(List<String> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "ShelveModel [shelveId=" + shelveId + ", sName=" + sName + ", BookCount=" + BookCount + ", books="
				+ books + "]";
	}
	
	


}
