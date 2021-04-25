package com.slrp.model;

import java.util.Optional;

import javax.crypto.spec.PBEKeySpec;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.slrp.security.AES;

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
		this.secret = AES.encrypt(secret, id.toString());
	}
	
	public void setPassword(String password) {
		this.password = AES.encrypt(password, this.secret);
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

	public User() {
		super();
	}
	
}