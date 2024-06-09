package com.taskbuzz.request;

import com.taskbuzz.entities.Role;

public class AddUserRequest {

	private String username;
	private String password;
	private String emailId;
	private Role role;
	private String phoneNumber;

	public AddUserRequest() {
	}

	public AddUserRequest(String username, String password, String emailid, Role role,String phoneNumber) {
		this.username = username;
		this.password = password;
		this.emailId = emailid;
		this.role = role;
		this.phoneNumber=phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailid) {
		this.emailId = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
