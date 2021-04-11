package com.slrp.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import java.util.ArrayList;
import java.util.Map;
import com.slrp.api.model.Student.Loan;

/**
 * Contributor Java File
 * @author louis
 * Holds the design of the Contributor user.
 */
@Entity
public class Contributor extends User {
	
	private ArrayList<Contribution> contributions;

	public Contributor(String Name, String contactInfo, String address, ArrayList<Contribution> contributions) {
		super(Name, contactInfo, address);
		// TODO Auto-generated constructor stub
		this.setContributions(contributions);
	}
	
	public static class Contribution {
		
		private Loan loan;
		private double contributionAmt;
		// TODO: This will be changed later to be using the date class.
		// Connor and I have decided on using MM/DD/YYYY as a norm for our date for the time being. 
		private String date;
		
		public Contribution(Loan l, double contributionAmt, String date) {
			this.setLoan(l);
			this.setContributionAmt(contributionAmt);
			this.setDate(date);
		}
		
		public Loan getLoan() {
			return loan;
		}
		public void setLoan(Loan loan) {
			this.loan = loan;
		}
		public double getContributionAmt() {
			return contributionAmt;
		}
		public void setContributionAmt(double contributionAmt) {
			this.contributionAmt = contributionAmt;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
	}

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
//	@Column(name="contributions")
//	private Map<User, Double> contributions;
// Keeping this here just in case the idea of making this a class doesn't work.

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
	
	public ArrayList<Contribution> getContributions() {
		return contributions;
	}

	public void setContributions(ArrayList<Contribution> contributions) {
		this.contributions = contributions;
	}
	
	public void addContribution(Contribution c) {
		this.getContributions().add(c);
	}
}
