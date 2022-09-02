package com.lib.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.dao.BookDao;
import com.lib.dao.BookIssueDao;
import com.lib.entities.Book;
import com.lib.entities.BookIssue;

/**
 * Servlet implementation class IssueBook
 */
@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	BookIssueDao dao = new BookIssueDao();
	List<Book> books = dao.DisplayIssuedBook();
	request.setAttribute("books", books);
	RequestDispatcher rd = request.getRequestDispatcher("/StudentBookIssue.jsp");
	rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		int sid = Integer.parseInt(request.getParameter("sid"));
		//String book_issue = request.getParameter("issue_date");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		  LocalDate date = LocalDate.now();  
		
	
	    
		//add 10 days
		LocalDate date2 = date.plusDays(10);
	
		//System.out.println("Date "+date+" plus 5 days is "+date2);
		String book_issue = date.toString();
		String book_return = date2.toString();
		//String book_return = request.getParameter("return_date");
		
		
		
		quantity = quantity-1;
		BookIssue bookissue = new BookIssue(book_id, sid, book_issue, book_return);
		BookIssueDao dao = new BookIssueDao();
		
		
		Book book = new Book(book_id, quantity);
		BookDao dao1 = new BookDao();
		
		
		if(dao.IssueBook(bookissue)) {
			PrintWriter out = response.getWriter();
			out.print("book issued");
			if(dao1.UpdateQuantity(book))
			{
				System.out.println("true");
			}
			else {
				System.out.println("false");
			}
			
			
		}
		else {
			PrintWriter out = response.getWriter();
			out.print(" book not issued");
		}
		
	}

}
