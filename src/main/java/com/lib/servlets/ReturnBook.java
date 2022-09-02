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

import com.lib.dao.BookIssueDao;
import com.lib.entities.BookIssue;

/**
 * Servlet implementation class ReturnBook
 */
@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
BookIssueDao dao = new BookIssueDao();
		
		List<BookIssue> books = dao.BookIssued();
		System.out.println(books.size());
		
		request.setAttribute("books", books);
		RequestDispatcher rd = request.getRequestDispatcher("/StudentViewBookIssued.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		BookIssue bookissue = new BookIssue(book_id);
		BookIssueDao dao = new BookIssueDao();
		
		if(dao.ReturnBook(bookissue)) {
			PrintWriter out = response.getWriter();
			out.print("Book Returned");
		}
		else {
			PrintWriter out = response.getWriter();
			out.print("Failed");	
		}
		
		
	}

}
