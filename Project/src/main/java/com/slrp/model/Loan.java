package com.slrp.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Loan {
	/**
	 * Auto generated primary key in the database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "l_id")
	private long id;

	/**
	 * The amount that is on the loan
	 */
	@Column(name = "l_amount")
	private String amount;

	/**
	 * The date the loan was loaded into the system
	 */
	@Column(name = "l_entered_system_date")
	private Timestamp enteredSystemDate;

	/**
	 * The date the borrower received the loan
	 */
	@Column(name = "l_date_disbursed")
	private Timestamp disbursedDate;

	/**
	 * The date the borrower enters repayment for this loan
	 */
	@Column(name = "l_first_repayment_date")
	private Timestamp firstRepaymentDate;

	@ManyToOne
	private Servicer servicer;

	@ManyToOne
	private Borrower borrower;

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

	public Timestamp getEnteredSystemDate() {
		return enteredSystemDate;
	}

	public void setEnteredSystemDate(Timestamp enteredSystemDate) {
		this.enteredSystemDate = enteredSystemDate;
	}

	public Timestamp getDisbursedDate() {
		return disbursedDate;
	}

	public void setDisbursedDate(Timestamp disbursedDate) {
		this.disbursedDate = disbursedDate;
	}

	public Timestamp getFirstRepaymentDate() {
		return firstRepaymentDate;
	}

	public void setFirstRepaymentDate(Timestamp firstRepaymentDate) {
		this.firstRepaymentDate = firstRepaymentDate;
	}

	public Servicer getServicer() {
		return servicer;
	}

	public void setServicer(Servicer servicer) {
		this.servicer = servicer;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public Loan(String amount, Timestamp enteredSystemDate, Timestamp disbursedDate, Timestamp firstRepaymentDate,
			Servicer servicer, Borrower borrower) {
		super();
		this.amount = amount;
		this.enteredSystemDate = enteredSystemDate;
		this.disbursedDate = disbursedDate;
		this.firstRepaymentDate = firstRepaymentDate;
		this.servicer = servicer;
		this.borrower = borrower;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", amount=" + amount + ", enteredSystemDate=" + enteredSystemDate + ", disbursedDate="
				+ disbursedDate + ", firstRepaymentDate=" + firstRepaymentDate + ", servicer=" + servicer
				+ ", borrower=" + borrower + "]";
	}

}
