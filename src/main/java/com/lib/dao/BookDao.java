package com.lib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lib.entities.Book;
import com.lib.helper.ConnectionProvider;

public class BookDao {
	

	public boolean addBook(Book book) {
		boolean f = false;
		Connection con = ConnectionProvider.getConnection();
		try {
			
			String query = "insert into book( Book_name,author, edition,Quantity,mid) values(?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1,book.getBook_name());
			stmt.setString(2,book.getAuthor());
			stmt.setString(3, book.getEdition());
			stmt.setInt(4,book.getQuantity());
			stmt.setInt(5, book.getMid());
			stmt.executeUpdate();
			f = true;
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Book> DisplayAllBooks(){
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
				 
//	                int id = rs.getInt("id");
//	                String name = rs.getString("name");
//	                String email = rs.getString("email");
//	                System.out.println(id + "\t\t" + name
//	                                   + "\t\t" + email);
	            }
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return books;
		
	}
	
	public List<Book> DisplayBookName(){
		Book book = null;
		List<Book> books = new ArrayList<Book>();
		try {
			String query = "select book_name , book_id from book";
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			 while (rs.next()) {
				 book = new Book();
				 book.setBook_name(rs.getString("Book_name"));
				 book.setBook_id(rs.getInt("book_id"));
				 books.add(book);
	            }
			 
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return books;
		
	}
	
	public boolean addBookQuantity(Book book) {
		boolean f = false;
		Connection con = ConnectionProvider.getConnection();
		try {
			
			String query = "update book set quantity=? where book_id=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1,book.getQuantity());
			stmt.setInt(2,book.getBook_id());
			
			stmt.executeUpdate();
			
			f = true;
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean DeleteBook(Book book) {
		boolean f = false;
		Connection con = ConnectionProvider.getConnection();
		try {
			
			String query = "DELETE FROM book WHERE book_id=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1,book.getBook_id());
			
			stmt.executeUpdate();
			
			f = true;
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean UpdateQuantity(Book book) {
		boolean f = false;
		Connection con = ConnectionProvider.getConnection();
		try {
			
			String query = "update book set quantity=? where book_id=?";
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setInt(1,book.getQuantity());
			stmt.setInt(2,book.getBook_id());
			
			stmt.executeUpdate();
			
			f = true;
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Book> DisplayIssuedBook()
    {
		Book book = null;
        List<Book> books = new ArrayList<>();
        try {
            Connection cnn = ConnectionProvider.getConnection();
            
            String query = " select book.book_id , student.name, book.book_name from ((book_issue inner join book on book.book_id = book_issue.book_id)inner  join student on student.sid = book_issue.sid)";
            PreparedStatement ps = cnn.prepareStatement(query);
          
                        
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
            	int book_id = rs.getInt("book_id");
            	String name = rs.getString("name");
            	String book_name = rs.getString("book_name");
            		
            	book = new Book();
            	book.setBook_id(book_id);
            	book.setName(name);
            	book.setBook_name(book_name);
            	 books.add(book);
            	
            	
            }
            

            
        } catch (Exception ex) 
        {
            System.err.println("get qus Err : "+ex.getMessage());
        }
        return books;
    }
	
	
	
}
	



