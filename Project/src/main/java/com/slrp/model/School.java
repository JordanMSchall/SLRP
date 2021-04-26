package com.slrp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class School {
	/**
	 * Auto generated primary key in the database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sc_id")
	private long id;

	/**
	 * The name of the program.
	 */
	@Column(name = "sc_name")
	private String name;

	/**
	 * The doe id of the school.
	 */
	@Column(name = "sc_doe_id")
	private String doeId;

	/**
	 * The contact for this school.
	 */
	@OneToOne
	private ContactInfo contact;

	/**
	 * The borrowers tied to this school.
	 */
	@OneToMany
	private List Borrower;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDoeId() {
		return doeId;
	}

	public void setDoeId(String doeId) {
		this.doeId = doeId;
	}

	public ContactInfo getContact() {
		return contact;
	}

	public void setContact(ContactInfo contact) {
		this.contact = contact;
	}

	public List getBorrowers() {
		return Borrower;
	}

	public void setBorrowers(List borrower) {
		Borrower = borrower;
	}

	public School(String name, String doeId, ContactInfo contact, List borrower) {
		super();
		this.name = name;
		this.doeId = doeId;
		this.contact = contact;
		Borrower = borrower;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", doeId=" + doeId + ", contact=" + contact + ", Borrower="
				+ Borrower + "]";
	}

}
