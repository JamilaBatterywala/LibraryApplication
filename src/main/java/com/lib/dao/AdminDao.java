
package com.lib.dao;
import java.sql.*;

import com.lib.entities.Admin;
import com.lib.helper.ConnectionProvider;

public class AdminDao {
	
	//to register admin
	public boolean saveAdmin(Admin admin) {
		boolean f = false;
		Connection con = ConnectionProvider.getConnection();
		try {
			
			String query = "insert into admin(name, Email,Role, password, membership_id) values(?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1,admin.getName());

			stmt.setString(2, admin.getEmail());
			stmt.setString(3, admin.getRole());
			stmt.setString(4, admin.getPassword());
			stmt.setString(5, admin.getMembership_id());
			stmt.executeUpdate(); 
			f = true;
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public Admin loginAdmin(String membership_id , String password) {
		Admin admin = null;
		Connection con = ConnectionProvider.getConnection();
		try {
			String query = "select *from admin where membership_id=? and password = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, membership_id);
			stmt.setString(2, password);
			ResultSet set = stmt.executeQuery();
			if(set.next())
			{
			
				
				
			int mid = set.getInt("mid");
			String name = 	set.getString("Name");
			String aname= 	set.getString("Name_of_Library");
			String address =set.getString("Address");
			String emial = set.getString("Email");
			String role = 	set.getString("role");
			String apassword = set.getString("password");
				
				admin = new Admin(mid, name, aname, address, emial, role, apassword);
				
				//user = new User(uid, name, mail, phone, type, branch, isVerify);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return admin;
		
	}
	
	public boolean addAdminDetails(Admin admin)
	{
		boolean f = false;
		Connection con = ConnectionProvider.getConnection();
		try {
			String Query = "update admin set name_of_library = ?,address =? where Email =?";
			PreparedStatement stmt = con.prepareStatement(Query);
			stmt.setString(1, admin.getName_of_library());
			stmt.setString(2,admin.getAddress());
			stmt.setString(3,admin.getEmail());
			
			stmt.executeUpdate();
			
			f = true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
	}
	
	

}
