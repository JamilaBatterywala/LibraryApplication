package com.lib.servlets;

import java.io.IOException;


import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.dao.AdminDao;
import com.lib.dao.StudentDao;
import com.lib.entities.Admin;
import com.lib.entities.Student;
import com.lib.helper.ConnectionProvider;
import com.lib.service.MailService;
import javax.mail.*;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Servlet implementation class RegisterStudent
 */
@WebServlet("/RegisterStudent")

public class RegisterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
		 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
            String option = request.getParameter("Role");
            String from = "String to, String from ,int id , String name";
		
		if(option.equals("Student")) { 
			String name = request.getParameter("Student_name");
			String email = request.getParameter("Student_email");
			//String role = request.getParameter("Role");
			String password = request.getParameter("student_password");
			Random r = new Random();
			int low = 10;
			int high = 100;
			int id = r.nextInt(high-low) + low;
			String id1 = "S" +id;
			Student student = new Student(name, email, option, password, id1);
		
			
			
			StudentDao dao1 = new StudentDao();
			if(dao1.saveStudent(student))
			{
//				MailService ms = new MailService();
//				
//				ms.sendEmail(email,from,id1,name); 
				
				PrintWriter out = response.getWriter();
				out.print("registration done");
				
				
			}
			else {
				PrintWriter out = response.getWriter();
				out.print("registration failed");
			}
		}
		
		else if(option.equals("Admin")) {
			String name = request.getParameter("Student_name");
			//String name_of_library = request.getParameter("admin_name_of_library");
			//String address = request.getParameter("admin_address");
			String email = request.getParameter("Student_email");
			
			String password = request.getParameter("student_password");
			Random r = new Random();
			int low = 10;
			int high = 100;
			int id = r.nextInt(high-low) + low;
			String id1 = "A" +id;
			Admin admin = new Admin(name, email, option, password, id1);
			
			
			AdminDao dao = new AdminDao();
			if(dao.saveAdmin(admin))
			{
				HttpSession s = request.getSession();
				s.setAttribute("currentAdmin1", admin);
				response.sendRedirect("Register_Admin.jsp");
				System.out.println("hello");
//				MailService ms = new MailService();
////				
//				ms.sendEmail(email,from,id1,name); 
//				PrintWriter out = response.getWriter();
//				out.print("registration done");
			}
			else {
				PrintWriter out = response.getWriter();
				out.print("registration failed");
			}
			
			
			
		}
		
		
		
	}
	
}
