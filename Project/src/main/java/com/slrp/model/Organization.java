package com.slrp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

/**
 * Organization Java File
 * @author louis, Jordan M. Schall
 * Holds the design of the Contributor user.
 */
@Entity
public class Organization implements Contributor {
	
	/**
	 * Auto generated primary key in the database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="org_id")
	private long id;
	
	/**
	 * The name of the program.
	 */
	@Column(name="org_name")
	private String name;
	
	/**
	 * The contributions made by this organization if any
	 */
	@OneToMany( targetEntity=Contribution.class )
	private List contributions;

	
	/**
	 * The contributions made by this organization if any
	 */
	@OneToOne( targetEntity=ContactInfo.class )
	private ContactInfo contactInfo;


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


	public List getContributions() {
		return contributions;
	}


	public void setContributions(List contributions) {
		this.contributions = contributions;
	}


	public ContactInfo getContactInfo() {
		return contactInfo;
	}


	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}


	public Organization(String name, List contributions, ContactInfo contactInfo) {
		super();
		this.name = name;
		this.contributions = contributions;
		this.contactInfo = contactInfo;
	}


	@Override
	public void makeContribution() {
		// TODO Auto-generated method stub
		
	}
	
}
