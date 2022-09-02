package com.lib.entities;

public class Admin {
	
	private int mid;
	private String name;
	private String name_of_library;
	private String address;
	private String Email;
	private String role;
	private String password;
	private String membership_id;
	public Admin() {
		
		// TODO Auto-generated constructor stub
	}
	public Admin(int mid, String name, String name_of_library, String address, String email, String role,
			String password) {
		
		this.mid = mid;
		this.name = name;
		this.name_of_library = name_of_library;
		this.address = address;
		Email = email;
		this.role = role;
		this.password = password;
	}
	public Admin(String name, String name_of_library, String address, String email, String role, String password) {
		super();
		this.name = name;
		this.name_of_library = name_of_library;
		this.address = address;
		Email = email;
		this.role = role;
		this.password = password;
	}
	public Admin(String name, String password) {
		super();
		this.name = name;
		
		this.password = password;
	}
	
	
	
	
	public Admin(String name, String email, String role, String password) {
		super();
		this.name = name;
		Email = email;
		this.role = role;
		this.password = password;
	}
	
	
	public Admin( String name_of_library, String address,String email) {
		super();
		
		this.name_of_library = name_of_library;
		this.address = address;
		Email = email;
	}
	
	
	public String getMembership_id() {
		return membership_id;
	}
	public void setMembership_id(String membership_id) {
		this.membership_id = membership_id;
	}
	
	public Admin(String name, String email, String role, String password, String membership_id) {
		super();
		this.name = name;
		Email = email;
		this.role = role;
		this.password = password;
		this.membership_id = membership_id;
	}
	//getters and setters
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName_of_library() {
		return name_of_library;
	}
	public void setName_of_library(String name_of_library) {
		this.name_of_library = name_of_library;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
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
