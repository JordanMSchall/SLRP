package com.slrp.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Map;

/**
 * Contributor Java File
 * @author louis
 * Holds the design of the Contributor user.
 */
@Entity
public class Contributor extends User {
	
	/*
	 * name: either a business name or personal name.
	 */
	@Column(name="name")
	private String name;
	
	/*
	 * contactInfo: a phone number.
	 */
	@Column(name="contactInfo")
	private String contactInfo;
	
	/*
	 * address: the contributor's street address.
	 */
	@Column(name="address")
	private String address;
	
	/*
	 * verifiedContributor
	 */
	@Column(name="verifiedContributor")
	private boolean verifiedContributor;
	
	/*
	 * contributions: A map where each key is a user and the value is the contribution amount.
	 */
	@Column(name="contributions")
	private Map<User, Double> contributions;

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

	public boolean isVerifiedContributor() {
		return verifiedContributor;
	}

	public void setVerifiedContributor(boolean verifiedContributor) {
		this.verifiedContributor = verifiedContributor;
	}

	public Map<User, Double> getContributions() {
		return contributions;
	}

	public void setContributions(Map<User, Double> contributions) {
		this.contributions = contributions;
	}
	
	
	

}
