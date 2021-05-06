package com.slrp.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PendingPayment {
	/**
	 * Auto generated primary key in the database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pending_payment_id")
	private long id;
	
	/**
	 * Amount the payment is for.
	 */
	@Column(name = "pp_date_added")
	private Timestamp dateApplied;

	
	/**
	 * The contribution the payment was created from.
	 */
	@OneToOne
	private Payment payment;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Timestamp getDateApplied() {
		return dateApplied;
	}


	public void setDateApplied(Timestamp dateApplied) {
		this.dateApplied = dateApplied;
	}


	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	public PendingPayment() {
		super();
	}


	public PendingPayment(Payment p) {
		this.payment = p;
		
	}
	
	
	
	
}
