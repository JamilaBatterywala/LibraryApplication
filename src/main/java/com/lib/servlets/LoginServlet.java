package com.lib.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.dao.AdminDao;
import com.lib.dao.BookDao;
import com.lib.dao.StudentDao;
import com.lib.entities.Admin;
import com.lib.entities.Book;
import com.lib.entities.Student;
import com.lib.helper.ConnectionProvider;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		
		
		if(id.contains("A")) {
			AdminDao dao = new AdminDao();
		
			String password = request.getParameter("password");
			Admin admin = dao.loginAdmin(id, password);
			if(admin!=null)
			{
				HttpSession s = request.getSession();
				s.setAttribute("currentAdmin", admin);
				response.sendRedirect("AdminIndex.jsp");
			System.out.println("hello");
				
				Cookie c1 = new Cookie("cqemail", id);
				Cookie c2 = new Cookie("cqpass", password);

                response.addCookie(c1);
                response.addCookie(c2);
			}
			else
			{
				
				
				PrintWriter out = response.getWriter();
				out.print("Login invalid");
		}}
			
		
		
		else if(id.contains("S")) {
			StudentDao dao = new StudentDao();
			
			String password = request.getParameter("password");
			Student student = dao.loginStudent(id, password);
			if(student!=null)
			{
				HttpSession s = request.getSession();
				s.setAttribute("currentAdmin", student);
				response.sendRedirect("StudentIndex.jsp");
				System.out.println("hello");
				
				Cookie c1 = new Cookie("cqemail", id);
				Cookie c2 = new Cookie("cqpass", password);

                response.addCookie(c1);
                response.addCookie(c2);
				
			}
				
			
			else
			{
				PrintWriter out = response.getWriter();
				out.print("Login invalid");			}			
		}
	
	
	}

}
