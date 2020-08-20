package com.nikhil.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Shelves")
public class Shelves {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shelveId;
	
	private String sName;
	private int bookCount;

	@OneToMany(targetEntity = Books.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "shel_book",referencedColumnName = "shelveId")
	private List<Books> book;
	
	
	
	

	public List<Books> getBook() {
		return book;
	}
	public void setBook(List<Books> book) {
		this.book = book;
	}
	public Shelves() {
		super();
	}
	
	
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
		return bookCount;
	}
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	

	@Override
	public String toString() {
		return "Shelves [shelveId=" + shelveId + ", sName=" + sName + ", bookCount=" + bookCount + "]";
	}

}
