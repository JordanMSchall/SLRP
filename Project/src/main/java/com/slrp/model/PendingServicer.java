package com.slrp.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PendingServicer {
	/**
	 * Auto generated primary key in the database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pending_servicer_id")
	private long id;
	
	/**
	 * Amount the servicer is for.
	 */
	@Column(name = "ps_date_added")
	private Timestamp dateApplied;

	
	/**
	 * The contribution the servicer was created from.
	 */
	@OneToOne
	private Servicer servicer;


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


	public Servicer getServicer() {
		return servicer;
	}


	public void setServicer(Servicer servicer) {
		this.servicer = servicer;
	}


	public PendingServicer() {
		super();
	}


	public PendingServicer(Servicer p) {
		this.servicer = p;
		
	}
	
	
	
	
}
