package com.slrp.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.slrp.Application;
import com.slrp.controller.HubController;
import com.slrp.model.Contribution;
import com.slrp.model.Loan;
import com.slrp.model.Payment;
import com.slrp.model.Person;
import com.slrp.service.ContributionService;
import com.slrp.service.LegalService;
import com.slrp.service.LoanService;
import com.slrp.service.PaymentService;
import com.slrp.service.PersonService;
import com.slrp.service.UserService;

@SpringBootTest(classes = Application.class)
public class TestRunner {
// Santiy Checks
//	@Test
//	public void falseTest() {
//		assertThat(false).isEqualTo(true);
//	}
//	
//	@Test
//	public void trueTest() {
//		assertThat(true).isEqualTo(true);
//	}
	
	
	
	@Autowired
	private HubController controller;

	@Autowired
	private LoanService loanService;

	@Autowired
	private PersonService personService;

	@Autowired
	private UserService profileService;

	@Autowired
	private LegalService legalService;

	@Autowired
	private ContributionService contributionService;
	
	@Autowired
	private PaymentService paymentService;

	@Test
	public void verifyHubController() {
		assertThat(controller).isNotNull();
	}

	@Test
	public void loanServiceTest() {
		assertThat(loanService).isNotNull();
	}

	@Test
	public void profileServiceTest() {
		assertThat(profileService).isNotNull();
	}

	@Test
	public void legalServiceTest() {
		assertThat(legalService).isNotNull();
	}

	@Test
	public void contributionServiceTest() {
		assertThat(contributionService).isNotNull();
	}
	
	@Test
	public void paymentsServiceTest() {
		assertThat(paymentService).isNotNull();
	}
	

	@Test
	public void loanTest() {
		Loan l = new Loan();
		loanService.createLoan(l);
		assertThat(loanService.getLoan(l).get().getId()).isEqualTo(l.getId());
		loanService.deleteLoan(l);
	}

	@Test
	public void personTest() {
		Person p = new Person();
		personService.createPerson(p);
		assertThat(personService.getPerson(p).get().getId()).isEqualTo(p.getId());
		personService.deletePerson(p);
	}
	
	@Test
	public void contributionTest() {
		Contribution c = new Contribution();
		contributionService.createContribution(c);
		assertThat(contributionService.getContribution(c).get().getId()).isEqualTo(c.getId());
		contributionService.deleteContribution(c);
	}
	
	@Test
	public void paymentTest() {
		Payment p = new Payment();
		paymentService.createPayment(p);
		assertThat(paymentService.getPayment(p).get().getId()).isEqualTo(p.getId());
		paymentService.deletePayment(p);
	}
	

}