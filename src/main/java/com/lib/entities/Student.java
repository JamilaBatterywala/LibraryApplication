package com.lib.entities;

public class Student {
	private int sid;
	private String name;
	private String Email;
	private String role;
	private String password;
	private String membership_id;
	public Student() {

		// TODO Auto-generated constructor stub
	}
	public Student(int sid, String name, String email, String role, String password) {
		this.sid = sid;
		this.name = name; 
		Email = email;
		this.role = role;
		this.password = password;
	}
	public Student(String name, String email, String role, String password ) {
		super();
		this.name = name;
		Email = email;
		this.role = role;
		this.password = password;
		
	}
	public Student(String name,  String password) {
		super();
		this.name = name;
		
		this.password = password;
	}
	
	
	public Student(String name, String email, String role, String password, String membership_id) {
		super();
		this.name = name;
		Email = email;
		this.role = role;
		this.password = password;
		this.membership_id = membership_id;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMembership_id() {
		return membership_id;
	}
	public void setMembership_id(String membership_id) {
		this.membership_id = membership_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}


