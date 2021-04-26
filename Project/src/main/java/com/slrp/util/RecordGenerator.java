package com.slrp.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.slrp.model.Borrower;
import com.slrp.model.ContactInfo;
import com.slrp.model.Contribution;
import com.slrp.model.Loan;
import com.slrp.model.Payment;
import com.slrp.model.Person;
import com.slrp.model.School;
import com.slrp.model.Servicer;

public class RecordGenerator {
	private static Random rand = new Random();

	public static List<Loan> generateRandomLoans(int n) {
		List<Loan> loans = new ArrayList<Loan>();

		// amnt, interest, ID
		for (int k = 0; k < n + 1; k++) {
			// Loan(String amount, Timestamp enteredSystemDate, Timestamp disbursedDate,
			// Timestamp firstRepaymentDate,
			// Servicer servicer, Person borrower)
			Date date = new Date();
			Timestamp ts = new Timestamp(date.getTime());
			Loan l = new Loan(Integer.toString(rand.nextInt(50000)), ts, ts, ts, generateServicer(),
					generateBorrower(generatePerson(), generateSchool()));
			loans.add(l);
		}
		return loans;
	}

	public static Loan generateRandomLoan(int amt) {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		return new Loan(Integer.toString(amt), ts, ts, ts, generateServicer(),
				generateBorrower(generatePerson(), generateSchool()));

	}

	public static void generateNLoansForBorrower(Borrower b, int n) {
		List<Loan> loans = new ArrayList<Loan>();

		// amnt, interest, ID
		for (int k = 0; k < n + 1; k++) {
			// Loan(String amount, Timestamp enteredSystemDate, Timestamp disbursedDate,
			// Timestamp firstRepaymentDate,
			// Servicer servicer, Borrower borrower)
			Date date = new Date();
			Timestamp ts = new Timestamp(date.getTime());
			Loan l = new Loan(Integer.toString(rand.nextInt(50000)), ts, ts, ts, generateServicer(), b);
			loans.add(l);
		}
		b.setLoans(loans);
	}

	public static Servicer generateServicer() {
		// Servicer(String name, String doeId, ContactInfo contact, List loans)
		Person p = generatePerson();
		generateContactInfo(p);

		return new Servicer("name_" + Integer.toString(rand.nextInt(50000)),
				"doe_id_" + Integer.toString(rand.nextInt(50000)), p.getContactInfo(), null);
	}

	public static void generateContactInfo(Person person) {
		// ContactInfo(String primaryPhone, String secondaryPhone, String address, int
		// roomNumber, String city,
		// String state, int zip, String email, Person person, Organization org)
		ContactInfo contactInfo = new ContactInfo(Integer.toString(rand.nextInt(50000)),
				Integer.toString(rand.nextInt(50000)), Integer.toString(rand.nextInt(50000)) + "st", 0, "Omaha",
				"Nebraska", 68106, "user" + Integer.toString(rand.nextInt(50000)) + "@unomaha.edu", person, null);
		person.setContactInfo(contactInfo);
	}

	public static Person generatePerson() {
		// Person(String firstName, String middleName, String lastName, String prefix,
		// String suffix, User user,
		// ContactInfo contactInfo, Borrower borrower, List contributions)
		Person person = new Person("first_" + Integer.toString(rand.nextInt(50000)),
				"middle_" + Integer.toString(rand.nextInt(50000)), "last_" + Integer.toString(rand.nextInt(50000)),
				null, null, null, null, null, null);
		generateContactInfo(person);
		return person;
	}

	public static School generateSchool() {
		// School(String name, String doeId, ContactInfo contact, List borrower)
		Person p = generatePerson();
		generateContactInfo(p);
		return new School("name_" + Integer.toString(rand.nextInt(50000)),
				"doeid_" + Integer.toString(rand.nextInt(50000)), p.getContactInfo(), null);
	}

	public static Borrower generateBorrower(Person person, School school) {
		// Borrower(long id, Integer cohortYear, Person person, School school, List
		// loans)
		Borrower borrower = new Borrower(2021, person, school, null);
		generateNLoansForBorrower(borrower, rand.nextInt(7));
		school.setBorrowers(Arrays.asList(borrower));
		person.setBorrower(borrower);
		return borrower;
	}

	public static void generatePersonContribution(Person person) {
		//Contribution(String amount, Timestamp contributionDate, Contributor contributor, Payment payment,
				//ContributionProgram program)
		Date date = new Date();
		Timestamp ts =new Timestamp(date.getTime());
		String amount = Integer.toString(rand.nextInt(50000));
		Contribution cont = new Contribution(amount, ts, person, null, null );
		// act as though the contribution is complete
		//Payment(String amount, Timestamp dateApplied, Loan loan, Contribution contribution)
		Payment payment = new Payment(amount, ts, generateRandomLoan(Integer.parseInt(amount) + 1000), cont );
		cont.addPayment(payment);

		
		person.addContribution(cont);
	}
}
