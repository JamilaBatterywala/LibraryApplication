package com.lib.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.dao.BookDao;
import com.lib.dao.StudentDao;
import com.lib.entities.Book;
import com.lib.entities.Student;
import com.lib.helper.ConnectionProvider;

/**
 * Servlet implementation class AddQuantity
 */
@WebServlet("/AddQuantity")
public class AddQuantity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuantity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao dao = new BookDao();
		List<Book> books = dao.DisplayBookName();
		System.out.println(books.size());
		request.setAttribute("books", books);
		RequestDispatcher rd = request.getRequestDispatcher("/AdminAddBookQuantity.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			int id  = Integer.parseInt(request.getParameter("book_id"));
			int quantity = Integer.parseInt(request.getParameter("book_quantity"));
			
	 
		Book book = new Book(id,quantity);
		BookDao dao = new BookDao();
		//Student student = new Student(name, email, role, password);
	
		if(dao.addBookQuantity(book))
		{
			
			PrintWriter out = response.getWriter();
			out.print("Updated");
		}
		else {
			PrintWriter out = response.getWriter();
			out.print("Update failed");
		}
	}

}
