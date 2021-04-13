package com.slrp.api.model;
import javax.persistence.Column;
import javax.persistence.Entity;

import java.util.ArrayList;
import java.util.Map;

/**
 * Contributor Java File
 * @author Connor
 * Holds the design of the Contributor user.
 */
@Entity
public class Student extends User {
	
	public class Loan {
		private int loanamount;
		private String ID;
		private double interest;
		private String dateTaken;
		//Additional Loan Information (Interest Rate, Last Date Paid, Date Taken)
		public Loan(int amount, double interest, String ID)
		{
			this.setLoanamount(amount);
			this.setInterest(interest);
			this.setID(ID);
		}
		
		public int getLoanamount() {
			return loanamount;
		}
		public void setLoanamount(int loanamount) {
			this.loanamount = loanamount;
		}
		public String getID() {
			return ID;
		}
		public void setID(String iD) {
			ID = iD;
		}
		public double getInterest() {
			return interest;
		}
		public void setInterest(double interest) {
			this.interest = interest;
		}
		public String getDateTaken() {
			return dateTaken;
		}
		public void setDateTaken(String dateTaken) {
			this.dateTaken = dateTaken;
		}
		
	}
	
	/*
	 * loans: A map where each key is a loan and the value is servicer.
	 */
	@Column(name="loans")
	private ArrayList<Loan> loans = new ArrayList<Loan>();

	public Student(String name, String phonenumber, String address, ArrayList<Loan> loans)
	{
		super(name,phonenumber,address);
		this.setLoans(loans);
	}
	public ArrayList<Loan> getLoans() {
		return loans;
	}

	public void setLoans(ArrayList<Loan> loans) {
		this.loans = loans;
	}
	public void addLoan(Loan l)
	{
		this.getLoans().add(l);
	}
}
