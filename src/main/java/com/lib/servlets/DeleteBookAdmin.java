package com.lib.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class DeleteBookAdmin
 */
@WebServlet("/DeleteBookAdmin")
public class DeleteBookAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		BookDao dao = new BookDao();
		List<Book> books = dao.DisplayAllBooks();
		request.setAttribute("books", books);
		RequestDispatcher rd = request.getRequestDispatcher("/AdminDeleteBook.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	int id = Integer.parseInt(request.getParameter("book_id"));
	

	Book book = new Book(id);
	BookDao dao = new BookDao();
	if(dao.DeleteBook(book))
	{
		PrintWriter out = response.getWriter();
		out.print("Book Deleted");
	}
	else
	{
		PrintWriter out = response.getWriter();
		out.print("Deletion Failed");
	}
	
	}

}
