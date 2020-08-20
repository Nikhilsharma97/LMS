package com.nikhil.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	
    private String author;
	private String bookName;
    private String currentStatus;
	
    
    
    @ManyToOne
    @JoinColumn(name = "B_s")
    private Shelves shelve;
    
    
    
    @Override
	public String toString() {
		return "Books [bookId=" + bookId + ", author=" + author + ", bookName=" + bookName + ", currentStatus="
				+ currentStatus + ", shelve=" + shelve + "]";
	}

	public Shelves getShelve() {
		return shelve;
	}

	public void setShelve(Shelves shelve) {
		this.shelve = shelve;
	}
    public Books() {
		super();
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


}
