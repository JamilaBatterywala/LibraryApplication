package com.lib.dao;
import java.sql.*;
import java.util.List;

import com.lib.entities.Admin;
import com.lib.entities.Student;
import com.lib.helper.ConnectionProvider;
public class StudentDao {
	
	//to register student
	public boolean saveStudent(Student student) {
		boolean f = false;
		Connection con = ConnectionProvider.getConnection();
		try {
			
			String query = "insert into student(name, Email,Role, password , membership_id) values(?,?,?,?,?)";
			PreparedStatement stmt =con.prepareStatement(query);
			stmt.setString(1,student.getName());
			stmt.setString(2, student.getEmail());  
			stmt.setString(3, student.getRole());
			stmt.setString(4, student.getPassword());
			stmt.setString(5, student.getMembership_id());
			stmt.executeUpdate();
			f = true;
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public Student loginStudent(String membership_id, String password) {
		Student student = null;
		Connection con = ConnectionProvider.getConnection();
		try {
			String query = "select *from student where membership_id=? and password = ?";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, membership_id);
			stmt.setString(2, password);
			ResultSet set = stmt.executeQuery();
			if(set.next())
			{
				
				int sid = set.getInt("sid");
				String sname =  set.getString("Name");
				String semail = set.getString("Email");
				String role =  set.getString("role");
				String spassword = set.getString("password");
				
				student = new Student(sid, sname, semail, role, spassword);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return student;
		
	}
	
	
	
	
	
		
	

}
