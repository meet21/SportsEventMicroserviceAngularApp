package com.cognizant.Model;

import jakarta.persistence.*;

@jakarta.persistence.Entity
public class Users {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String emailId;
private String userName;
private String password;

public Users() {
	
}
public Users(int id, String emailId, String userName, String password) {
	super();
	this.id = id;
	this.emailId = emailId;
	this.userName = userName;
	this.password = password;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}