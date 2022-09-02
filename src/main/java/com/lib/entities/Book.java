package com.lib.entities;

public class Book {
	
	private int  book_id;
	private String book_name;
	private String author;
	private String edition;
	private int quantity;
	private int mid;
	private String name;
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(int book_id, String book_name, String author, String edition, int quantity , int mid) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.author = author;
		this.edition = edition;
		this.quantity = quantity;
		this.mid = mid;
	}
	public Book(String book_name, String author, String edition, int quantity,int mid) {
		super();
		this.book_name = book_name;
		this.author = author;
		this.edition = edition;
		this.quantity = quantity;
		this.mid=mid;
	}


	public Book(int book_id) {
		super();
		this.book_id = book_id;
	}
	
	 
	
	
	public Book(int book_id, String book_name, String name) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.name = name;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public Book(int book_id,  int quantity) {
		super();
		this.book_id = book_id;
		
		this.quantity = quantity;
	}
	
	
	public Book(int book_id, String edition) {
		super();
		this.book_id = book_id;
		this.edition = edition;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	

}
