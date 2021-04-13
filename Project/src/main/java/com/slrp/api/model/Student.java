package com.slrp.api.model;
import javax.persistence.Column;
import javax.persistence.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Contributor Java File
 * @author Connor
 * Holds the design of the Contributor user.
 */
@Entity
public class Student{
	
	/*
	 * loans: A map where each key is a loan and the value is servicer.
	 */
	@Column(name="loans")
	private List<Loan> loans;

	public Student(String name, String phonenumber, String address, List<?> loans)
	{
		// list of type...
		this.setLoans(loans);
	}
	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<?> loans) {
		// list of type?
		this.loans = (List<Loan>) loans;
	}
	public void addLoan(Loan l)
	{
		this.getLoans().add(l);
	}
}