package com.slrp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Borrower {
	/**
	 * Auto generated primary key in the database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "b_id")
	private long id;

	/**
	 * The cohort year of this borrower
	 */
	@Column(name = "b_cohort_year")
	private Integer cohortYear;

	/**
	 * The person that is this borrower
	 */
	@OneToOne
	private Person person;

	/**
	 * The school that this borrower attended
	 */
	@OneToOne
	private School school;

	/**
	 * The loans taken by this borrower
	 */
	@OneToMany
	private List loans;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getCohortYear() {
		return cohortYear;
	}

	public void setCohortYear(Integer cohortYear) {
		this.cohortYear = cohortYear;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public List getLoans() {
		return loans;
	}

	public void setLoans(List loans) {
		this.loans = loans;
	}

	public Borrower( Integer cohortYear, Person person, School school, List loans) {
		super();
		this.cohortYear = cohortYear;
		this.person = person;
		this.school = school;
		this.loans = loans;
	}

	@Override
	public String toString() {
		return "Borrower [id=" + id + ", cohortYear=" + cohortYear + ", person=" + person + ", school=" + school
				+ ", loans=" + loans + "]";
	}

}
