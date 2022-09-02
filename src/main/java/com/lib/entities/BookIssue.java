package com.lib.entities;

public class BookIssue {
	private int book_id;
	private int sid;
	private String book_issue;
	private String book_return;
	private String book_name;
	private String author;
	private String edition;
	public BookIssue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookIssue(int book_id, int sid, String book_issue, String book_return) {
		super();
		this.book_id = book_id;
		this.sid = sid;
		this.book_issue = book_issue;
		this.book_return = book_return;
	}
	
	
	
	
	public BookIssue(int book_id) {
		super();
		this.book_id = book_id;
	}
	public BookIssue(int book_id, String book_return) {
		super();
		this.book_id = book_id;
		this.book_return = book_return;
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
	public BookIssue(int book_id, String book_issue, String book_return, String book_name, String author,
			String edition) {
		super();
		this.book_id = book_id;
		this.book_issue = book_issue;
		this.book_return = book_return;
		this.book_name = book_name;
		this.author = author;
		this.edition = edition;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getBook_issue() {
		return book_issue;
	}
	public void setBook_issue(String book_issue) {
		this.book_issue = book_issue;
	}
	public String getBook_return() {
		return book_return;
	}
	public void setBook_return(String book_return) {
		this.book_return = book_return;
	}
	
	

}
