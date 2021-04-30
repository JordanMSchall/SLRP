package com.slrp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class User {
	/**
	 * Auto generated primary key in the database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "u_id")
	private Integer id;

	/**
	 * The user username.
	 */
	@Column(name = "u_name")
	private String username;

	/**
	 * The user password encrypted using AES in the setter. 
	 */
	@Column(name = "u_encrypted_password")
	private String password;
	
	/**
	 * The secret used to encrypt the password also encoded. 
	 */
	@Column(name = "u_encrypted_secret")
	private String secret;

	/**
	 * The type of user, school, org, etc...
	 */
	@Column(name = "u_type")
	private String type;
	
	@OneToOne
	private Person person;
	
	
	@ManyToOne
	private Organization org;

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
		return password;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncryptedSecret() {
		return this.secret;
	}
	
	public String getEncryptedPassword() {
		return this.password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", secret=" + secret + ", type="
				+ type + ", person=" + person + ", org=" + org + "]";
	}

	
	
}