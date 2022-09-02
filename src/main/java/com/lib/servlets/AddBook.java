package com.lib.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/AdminAddBooks.jsp");
		rd.forward(req, resp);
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("book_name");
		String author = request.getParameter("book_author_name");
		String edition = request.getParameter("book_edition");
		int quantity = Integer.parseInt(request.getParameter("book_quantity"));
		int mid = Integer.parseInt(request.getParameter("mid"));
		Book book = new Book(name, author, edition, quantity, mid);
		BookDao dao = new BookDao();
		if(dao.addBook(book))
		{
			PrintWriter out = response.getWriter();
			out.print("book added");
		}
		else {
			PrintWriter out = response.getWriter();
			out.print(" failed");
		}
		
	}

}
