package com.nikhil.demo.entity.model;

public class BooksModel {
	
	
private int bookId;
	
    private String author;
	private String bookName;
    private String currentStatus;
    
    private int shelve;
    
    
	public int getShelve() {
		return shelve;
	}
	public void setShelve(int shelve) {
		this.shelve = shelve;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	@Override
	public String toString() {
		return "BooksModel [bookId=" + bookId + ", author=" + author + ", bookName=" + bookName + ", currentStatus="
				+ currentStatus + "]";
	}
	
    
    

}
