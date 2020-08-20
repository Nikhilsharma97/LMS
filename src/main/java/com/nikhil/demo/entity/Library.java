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
@Table(name = "Library")

public class Library {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int libIsbn;
	
	private String libName;
	
	
	@OneToMany(targetEntity = Shelves.class,cascade = CascadeType.ALL)
	@JoinTable(name="lib_shelve",joinColumns = @JoinColumn(name = "libIsbn"),inverseJoinColumns = @JoinColumn(name="shelveId"))
//	@JoinColumn(name = "lib_slv",referencedColumnName = "libIsbn")
//	
	private List<Shelves> shelve ;
	

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

	public List<Shelves> getShelve() {
		return shelve;
	}

	public void setShelve(List<Shelves> shelve) {
		this.shelve = shelve;
	}

	public Library(int libIsbn, String libName, List<Shelves> shelve) {
		super();
		this.libIsbn = libIsbn;
		this.libName = libName;
		this.shelve = shelve;
	}

	public Library() {
		super();
	}

	@Override
	public String toString() {
		return "Library [libIsbn=" + libIsbn + ", libName=" + libName + ", shelve=" + shelve + "]";
	}
	
	
	
	
	

}
