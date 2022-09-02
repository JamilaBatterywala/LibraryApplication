package com.lib.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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
 * Servlet implementation class RenewBook
 */
@WebServlet("/RenewBook")
public class RenewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RenewBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		String book_return= request.getParameter("book_return");
		
		LocalDate localDate = LocalDate.parse(book_return);
		localDate = localDate.plusDays(10);
		
		String bookReturnString = localDate.toString();
		
		
		BookIssue bookissue = new BookIssue(book_id,bookReturnString);
		BookIssueDao dao = new BookIssueDao();
		
		if(dao.RenewBook(bookissue)) {
			PrintWriter out = response.getWriter();
			out.print("Book Renewed");
		}
		else {
			PrintWriter out = response.getWriter();
			out.print("Failed");	
		}
		
		
		
	}

}
