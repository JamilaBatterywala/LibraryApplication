package com.lib.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.lib.entities.Admin;
import com.lib.entities.Book;
import com.lib.entities.BookIssue;

import com.lib.helper.ConnectionProvider;


public class BookIssueDao {
	
	public List<Book> DisplayIssuedBook(){
		Book book = null;	
		List<Book> books = new ArrayList<Book>();
	try {
		String query = "select*from book";
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		 while (rs.next()) {
			 book = new Book();
			 book.setBook_id(rs.getInt("book_id"));
			 book.setBook_name(rs.getString("Book_name"));
			 book.setAuthor(rs.getString("author"));				
			 book.setEdition(rs.getString("edition"));
			 book.setQuantity(rs.getInt("quantity"));
			 books.add(book);
			 

                                  
            }
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return books;
	
}

	public boolean IssueBook(BookIssue bookissue) {
		boolean f = false;
		Connection con = ConnectionProvider.getConnection();
		try {
			
			String query = "insert into book_issue( book_id,sid,book_issue,book_return) values(?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, bookissue.getBook_id());
			stmt.setInt(2, bookissue.getSid());
			stmt.setString(3,bookissue.getBook_issue());
			stmt.setString(4, bookissue.getBook_return());
		
			stmt.executeUpdate();
			f = true;
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public List<BookIssue> BookIssued(){
		BookIssue bookissue = null;
		List<BookIssue> bookissued = new ArrayList<>();
		try {
			Connection con = ConnectionProvider.getConnection();
			String query = "select book.book_id,book.book_name,book.author,book.edition,book_issue.book_issue,book_issue.book_return from book , book_issue where book.book_id = book_issue.book_id";
			
			
			PreparedStatement stmt = con.prepareStatement(query);
			
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{	
				int book_id = rs.getInt("book_id");
				String Book_name = rs.getString("book_name");
				String author = rs.getString("author");
				String edition = rs.getString("edition");
				String book_issue = rs.getString("book_issue");
				String book_return = rs.getString("book_return");
				
				bookissue = new BookIssue();
				
				bookissue.setBook_id( book_id);
				bookissue.setBook_name(Book_name);
				bookissue.setAuthor(author);
				bookissue.setEdition(edition);
				bookissue.setBook_issue(book_issue);
				bookissue.setBook_return(book_return);
				
				bookissued.add(bookissue);
			
				
				
			
				
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	return bookissued;
	}
	
	public boolean RenewBook(BookIssue bookissue) {
		boolean f = false;
		Connection con = ConnectionProvider.getConnection();
		try {
			
			String query = "update book_issue set book_return = ?where book_id = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1,bookissue.getBook_return());
			stmt.setInt(2,bookissue.getBook_id());
			
			stmt.executeUpdate();
			
			f = true;
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}	
	
	public boolean ReturnBook(BookIssue bookissue) {
		boolean f = false;
		Connection con = ConnectionProvider.getConnection();
		try {
			
			String query = "delete from book_issue where book_id=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1,bookissue.getBook_id());
			
			stmt.executeUpdate();
			
			f = true;
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}	
	
	


	
	
	
	
}


