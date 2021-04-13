package com.slrp.api.model;

public class Loan {
	private int amount;
	private String ID;
	private double interest;
	private String dateTaken;
	private Servicer servicer;

	// Additional Loan Information (Interest Rate, Last Date Paid, Date Taken)
	public Loan(int amount, double interest, String ID) {
		this.setAmount(amount);
		this.setInterest(interest);
		this.setID(ID);
	}

	//new Loan(5000 + rand.nextInt(50000), rand.nextDouble(), Integer.toString(1000 + rand.nextInt(9999)), "Great Lakes");
	public Loan(int amount, double interest, String ID, Servicer servicer) {
		// TODO Auto-generated constructor stub
		this.setAmount(amount);
		this.setInterest(interest);
		this.setID(ID);
		this.setServicer(servicer);
	}

	public Servicer getServicer() {
		return servicer;
	}

	public void setServicer(Servicer servicer) {
		this.servicer = servicer;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public String getDateTaken() {
		return dateTaken;
	}

	public void setDateTaken(String dateTaken) {
		this.dateTaken = dateTaken;
	}

}
