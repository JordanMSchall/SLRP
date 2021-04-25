package com.slrp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Person implements Contributor {

	/**
	 * Auto generated primary key in the database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "p_id")
	private long id;

	/**
	 * The first name of the person.
	 */
	@Column(name = "p_first_name")
	private String firstName;

	/**
	 * The middle name of the person.
	 */
	@Column(name = "p_middle_name")
	private String middleName;

	/**
	 * The last name of the person.
	 */
	@Column(name = "p_last_name")
	private String lastName;

	/**
	 * The prefix of the person.
	 */
	@Column(name = "p_prefix")
	private String prefix;

	/**
	 * The suffix of the person.
	 */
	@Column(name = "p_suffix")
	private String suffix;

	/**
	 * The user the person is tied to.
	 */
	@OneToOne
	private User user;

	/**
	 * The contact info of the person.
	 */
	@OneToOne
	private ContactInfo contactInfo;

	/**
	 * The Department of Education definition of a borrower that maps to this person
	 * if any.
	 */
	@OneToMany
	private Borrower borrower;

	/**
	 * The contributions made by this organization if any
	 */
	@OneToMany(targetEntity = Contribution.class)
	private List<Contribution> contributions;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public List<Contribution> getContributions() {
		return contributions;
	}

	public void setContributions(List<Contribution> contributions) {
		this.contributions = contributions;
	}

	public Person(String firstName, String middleName, String lastName, String prefix, String suffix, User user,
			ContactInfo contactInfo, Borrower borrower, List<Contribution> contributions) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.prefix = prefix;
		this.suffix = suffix;
		this.user = user;
		this.contactInfo = contactInfo;
		this.borrower = borrower;
		this.contributions = contributions;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", prefix=" + prefix + ", suffix=" + suffix + ", user=" + user + ", contactInfo=" + contactInfo
				+ ", borrower=" + borrower + ", contributions=" + contributions + "]";
	}

	public String getFullName() {
		String fullname = "";
		if (this.prefix != null && !this.prefix.isEmpty())
			fullname += this.prefix + " ";
		fullname += this.firstName + " ";
		if (this.middleName != null && !this.middleName.isEmpty())
			fullname += this.middleName + " ";
		fullname += this.lastName + " ";
		return fullname;
	}

	public void addContribution(Contribution cont) {
		if ( this.contributions == null )
			this.contributions = new ArrayList<Contribution>();
		this.contributions.add(cont);
		
	}

	@Override
	public void makeContribution() {
		// TODO Auto-generated method stub
		
	}

}
