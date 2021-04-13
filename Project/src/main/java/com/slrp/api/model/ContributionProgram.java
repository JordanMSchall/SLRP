package com.slrp.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ContributionProgram {
	/**
	 * Auto generated primary key in the database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cp_id")
	private long id;
	
	/**
	 * The name of the program.
	 */
	@Column(name = "cp_name")
	private String name;
	
	
	/**
	 * A description of the payment program
	 */
	@Column(name = "cp_description")
	private String description;
	
	/**
	 * The query that is used by the program to generate payments
	 */
	@Column(name = "cp_payment_query")
	private String programPaymentsQuery;
	
	/**
	 * <p>This method is used to generate payments using 
	 * a query defined in the database table. This is 
	 * initialized by a contribution
	 * </p>
	 * @return the payments generated by this program
	 * @since 1.0
	 */
	private List getPayments() {
		List<Payment> payments = new ArrayList<Payment>();
		// TODO: insert logic to use the contribution query to 
		// create payments
		return payments;
	}
	

}
