package com.lib.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.dao.AdminDao;
import com.lib.entities.Admin;
import com.lib.helper.ConnectionProvider;

/**
 * Servlet implementation class RegisterAdmin
 */
@WebServlet("/RegisterAdmin")
public class RegisterAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email =request.getParameter("email");
		String name_of_library = request.getParameter("admin_name_of_library");
		String address = request.getParameter("admin_address");
	
		Admin admin =new Admin(name_of_library,address,email);
		
		AdminDao dao = new AdminDao();
		if(dao.addAdminDetails(admin))
		{
			
			PrintWriter out = response.getWriter();
			out.print(email + name_of_library + address);
			
		}
		else {
			PrintWriter out = response.getWriter();
			out.print("registration failed");
		}
			
		
		
	}

	

}
