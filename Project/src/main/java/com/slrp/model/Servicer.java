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
public class Servicer {
	/**
	 * Auto generated primary key in the database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "se_id")
	private long id;

	/**
	 * The name of the program.
	 */
	@Column(name = "se_name")
	private String name;

	/**
	 * The doe id of the school.
	 */
	@Column(name = "se_doe_id")
	private String doeId;

	/**
	 * The contact for this school.
	 */
	@OneToOne
	private ContactInfo contact;

	/**
	 * The loans managed by this servicer.
	 */
	@OneToMany(targetEntity = Loan.class)
	private List<Loan> loans;

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

	public List getLoans() {
		return loans;
	}

	public void setLoans(List loans) {
		this.loans = loans;
	}

	public Servicer(String name, String doeId, ContactInfo contact, List loans) {
		super();
		this.name = name;
		this.doeId = doeId;
		this.contact = contact;
		this.loans = loans;
	}

	public Servicer() {
	}
	
	public Servicer(String name) {
		super();
		this.name = name;
	}


}
