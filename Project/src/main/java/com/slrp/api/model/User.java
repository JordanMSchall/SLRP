package com.slrp.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User {

	@Column(name="id")
	private Integer id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;

	
//Possible Refactor for User
	/*
	 * name: Official School Name
	 */
	@Column(name="name")
	private String name;
	
	/*
	 * contactInfo: a phone number.
	 */
	@Column(name="contactInfo")
	private String contactInfo;
	
	/*
	 * address: School street address.
	 */
	@Column(name="address")
	private String address;
	
	public User(String Name, String contactInfo, String address)
	{
		this.setAddress(address);
		this.setName(Name);
		this.setContactInfo(contactInfo);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		// random hash
		return password;
	}

	public void setPassword(String password) {
		// random hash
		this.password = password;
	} 
	
	//Refactored Getters/Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
