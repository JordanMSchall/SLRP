package com.slrp.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.slrp.api.model.Loan;
import com.slrp.api.model.Servicer;

public class RecordGenerator {
	
	public static List<Loan> generateLoans(int n){
	List<Loan> loans = new  ArrayList<Loan>();
	Random rand = new Random();
	String id = Integer.toString(1000 + rand.nextInt(9999));
	int amount = 5000 + rand.nextInt(50000);
	double interest = 5000 + rand.nextInt(50000);

	//amnt, interest, ID
	for (int k = 0; k < n + 1; k++) {
		Loan l = new Loan(amount, interest, id , generateServicer());
		loans.add(l);
	}
	return loans;
	}

	private static Servicer generateServicer() {
		Random rand = new Random();
		return new Servicer("Servicer" + rand.nextInt(50000));
	}
}
