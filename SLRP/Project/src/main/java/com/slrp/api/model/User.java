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
	
	
	
}
