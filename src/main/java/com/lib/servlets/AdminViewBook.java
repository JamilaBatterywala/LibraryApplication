package com.lib.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.dao.BookDao;
import com.lib.entities.Book;

/**
 * Servlet implementation class AdminViewBook
 */
@WebServlet("/AdminViewBook")
public class AdminViewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BookDao dao = new BookDao();
		List<Book> books = dao.DisplayAllBooks();
		request.setAttribute("books", books);
		RequestDispatcher rd = request.getRequestDispatcher("/AdminViewAllBooks.jsp");
		rd.forward(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
