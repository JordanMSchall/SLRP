package com.slrp.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import org.json.JSONObject;

@Entity
public class Contribution {
	/**
	 * Auto generated primary key in the database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/**
	 * Amount is changed through the Currency interface.
	 */
	@Column(name = "cont_amount")
	private String amount;

	/**
	 * Contribution Date is the date in which the contribution was made.
	 */
	@Column(name = "cont_date")
	//TODO: This needs to be using Timestamp, using a string for now.
	private String contributionDate;


	/**
	 * A single contribution may go to many loans
	 * 
	 */
	@OneToMany(targetEntity = Payment.class)
	private List<Payment> payments;

	/**
	 * A ContributionProgram is used to create payments. A contribution program may
	 * be to pay a single loan or multiple loans and these rules will be handled
	 * there.
	 * 
	 */
	@ManyToOne(targetEntity = ContributionProgram.class)
	private ContributionProgram program;
	

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

	public String getContributionDate() {
		return contributionDate;
	}

	public void setContributionDate(String contributionDate) {
		this.contributionDate = contributionDate;
	}

//	public void setContributor(Organization contributor) {
//		this.contributor = contributor;
//	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public ContributionProgram getProgram() {
		return program;
	}

	public void setProgram(ContributionProgram program) {
		this.program = program;
	}

	public Contribution(String amount, String contributionDate,  List<Payment> payments,
			ContributionProgram program) {
		super();
		this.amount = amount;
		this.contributionDate = contributionDate;
		//this.contributor = contributor;
		this.payments = payments;
		this.program = program;
	}
	
	public Contribution() {
		
	};

	public Contribution(String amount2, Timestamp ts, Person person, Object program2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Contribution [id=" + id + ", amount=" + amount + ", contributionDate=" + contributionDate
				 + ", payments=" + payments + ", program=" + program + "]";
	}

	public JSONObject toJSON() {

		JSONObject obj = new JSONObject();
		obj.put("id", this.id);
		obj.put("amount", this.amount);
		obj.put("contributionDate", this.contributionDate);
		//obj.put("contributor", this.contributor);
		obj.put("payments", this.payments);
		obj.put("program", this.program);

		return obj;
	}

	public void addPayment(Payment payment) {
		if ( this.payments == null )
			this.payments = new ArrayList<Payment>();
		this.payments.add(payment);
		
	}

}
