package com.wipro.HackathonWave20Team2.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
// This hibernate annotation creates table in the hackathon DataBase
public class UserBean {
	@Id
	private String id;
	private String userName;
	private int age;
	private String address;
	private String emailId;
	
	
	// Default no-arg Constructor
	public UserBean() {
		super();
	}

	// Parameterised Constructor if you want to set values using a constructor
	public UserBean(String id, String userName, int age, String address, String emailId) {
		super();
		this.id = id;
		this.userName = userName;
		this.age = age;
		this.address = address;
		this.emailId = emailId;
	}
	
	// Setter and Getter methods if you want to set values individually
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


<<<<<<< HEAD
=======
	public int getAge() {
		return age;
	}



>>>>>>> 8f0d8a2d76429cede2e83589e068027e6d62eb37
	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
