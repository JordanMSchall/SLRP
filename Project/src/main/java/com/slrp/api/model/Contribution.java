package com.slrp.api.model;

import javax.persistence.Entity;

@Entity
public  class Contribution {
	
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
