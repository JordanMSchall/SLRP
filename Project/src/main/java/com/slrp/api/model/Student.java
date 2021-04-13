package com.slrp.api.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;


/**
 * Contributor Java File
 * @author Connor
 * Holds the design of the Contributor user.
 */
@Entity
public class Student{
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
	 * loans: A map where each key is a loan and the value is servicer.
	 */
	@Column(name="loans")
	private List<Loan> loans;

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
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	
	public Student(String name, String phonenumber, String address, List<Loan> loans)
	{
		// list of type...
		this.setLoans(loans);
		this.setAddress(address);
		this.setName(name);
		this.setContactInfo(phonenumber);
	}
	public List<Loan> getLoans() {
		return loans;
	}

	public void addLoan(Loan l)
	{
		this.getLoans().add(l);
	}

}