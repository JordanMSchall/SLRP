package com.slrp.api.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Payment {
	
	/**
	 * Auto generated primary key in the database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pay_id")
	private long id;
	
	
	/**
	 * Amount the payment is for.
	 */
	@Column(name = "pay_amount")
	private String amount;
	
	
	/**
	 * Amount the payment is for.
	 */
	@Column(name = "pay_date_applied")
	private Timestamp dateApplied;
	
	/**
	 * The loan the payment is for.
	 */
	@ManyToOne
	private Loan loan;
	
	/**
	 * The contribution the payment was created from.
	 */
	@ManyToOne
	private Contribution contribution;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Timestamp getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(Timestamp dateApplied) {
		this.dateApplied = dateApplied;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public Contribution getContribution() {
		return contribution;
	}

	public void setContribution(Contribution contribution) {
		this.contribution = contribution;
	}

	public Payment(String amount, Timestamp dateApplied, Loan loan, Contribution contribution) {
		super();
		this.amount = amount;
		this.dateApplied = dateApplied;
		this.loan = loan;
		this.contribution = contribution;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", dateApplied=" + dateApplied + ", loan=" + loan
				+ ", contribution=" + contribution + "]";
	}


}
