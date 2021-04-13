package com.slrp.api.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class ContactInfo {

	/**
	 * Auto generated primary key in the database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ci_id")
	private long id;

	/**
	 * Primary Phone Number
	 */
	@Column(name = "ci_primary_phone")
	private String primaryPhone;

	/**
	 * Secondary Phone Number
	 */
	@Column(name = "ci_secondary_phone")
	private String secondaryPhone;

	/**
	 * Address
	 */
	@Column(name = "ci_address")
	private String address;

	/**
	 * Apartment or Suite number
	 */
	@Column(name = "ci_room_number")
	private int roomNumber;

	/**
	 * city
	 */
	@Column(name = "ci_city")
	private String city;

	/**
	 * State
	 */
	@Column(name = "ci_state")
	private String state;

	/**
	 * zip code
	 */
	@Column(name = "ci_zip_code")
	private int zip;

	/**
	 * email
	 */
	@Column(name = "ci_email")
	private String email;

	/**
	 * The person that belongs to this contact
	 */
	@OneToOne
	private Person person;

	/**
	 * The organization that belongs to this contact
	 */
	@OneToOne
	private Organization org;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getSecondaryPhone() {
		return secondaryPhone;
	}

	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	public ContactInfo(String primaryPhone, String secondaryPhone, String address, int roomNumber, String city,
			String state, int zip, String email, Person person, Organization org) {
		super();
		this.primaryPhone = primaryPhone;
		this.secondaryPhone = secondaryPhone;
		this.address = address;
		this.roomNumber = roomNumber;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.person = person;
		this.org = org;
	}
	
	public String getFormattedAddress() {
		return this.address + "," + this.city + ","+ this.state + "," + this.zip;
	}

}
