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
import javax.persistence.OneToOne;

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
	private Timestamp contributionDate;

	/**
	 * A Contributor is a Person or Organization that has made a contribution.
	 */
	@ManyToOne
	private Organization org;

	/**
	 * A Contributor is a Person or Organization that has made a contribution.
	 */
	@ManyToOne
	private Person person;
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
	@OneToOne(targetEntity = Payment.class)
	private ContributionProgram program;

	private Contributor contributor;

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

	public Timestamp getContributionDate() {
		return contributionDate;
	}

	public void setContributionDate(Timestamp contributionDate) {
		this.contributionDate = contributionDate;
	}

	public Organization getContributor() {
		return org;
	}

	public void setContributor(Organization contributor) {
		this.contributor = contributor;
	}


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

	public Contribution(String amount, Timestamp contributionDate, Contributor contributor, List<Payment> payments,
			ContributionProgram program) {
		super();
		this.amount = amount;
		this.contributionDate = contributionDate;
		this.contributor = contributor;
		this.payments = payments;
		this.program = program;
	}

	@Override
	public String toString() {
		return "Contribution [id=" + id + ", amount=" + amount + ", contributionDate=" + contributionDate
				+ ", contributor=" + contributor + ", payments=" + payments + ", program=" + program + "]";
	}

	public JSONObject toJSON() {

		JSONObject obj = new JSONObject();
		obj.put("id", this.id);
		obj.put("amount", this.amount);
		obj.put("contributionDate", this.contributionDate);
		obj.put("contributor", this.contributor);
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
