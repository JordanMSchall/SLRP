package com.slrp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.slrp.model.Borrower;
import com.slrp.model.Contribution;
import com.slrp.model.Loan;
import com.slrp.model.Payment;
import com.slrp.model.Person;
import com.slrp.model.Servicer;
import com.slrp.service.BorrowerService;
import com.slrp.service.LoanService;
import com.slrp.service.PaymentService;
import com.slrp.service.PersonService;
import com.slrp.service.ServicerService;

@SessionAttributes({ "person", "borrower" })
@Controller
public class BorrowerController {

	@Autowired
	BorrowerService borrowerService;

	@Autowired
	LoanService loanService;

	@Autowired
	ServicerService servicerService;
	
	@Autowired
	PersonService personService;

	@Autowired
	PaymentService paymentService;
	
	@RequestMapping("/loadloan")
	public String login(@SessionAttribute("borrower") Borrower borrower, @RequestParam String loanId,
			@RequestParam String servicer, @RequestParam String amount, Model model) {
		Loan loan = new Loan();
		loan.setAmount(amount);
		loan.setBorrower(borrower);
		loan.setLoanDoeId(loanId);
		Servicer s = servicerService.getServicerByName(servicer);
		loan.setServicer(s);
		borrower.addLoan(loan);
		loanService.createLoan(loan);
		borrowerService.updateBorrower(borrower);
		return HubController.borrower(model);
	}

	@RequestMapping("/payloan")
	public String login(@SessionAttribute("borrower") Borrower borrower, @SessionAttribute("person") Person person, @RequestParam String loanId,
			@RequestParam String amount, @RequestParam String cardNumber, @RequestParam String cvv,
			@RequestParam String billingZip, Model model) {
		Loan loan = loanService.getLoanByDoeIdAndBorrower(loanId, borrower);
		Contribution c = new Contribution();
		paymentService.createContribution(c);
		Payment p = new Payment();
		paymentService.createPayment(p);
		p.setAmount(amount);
		p.setLoan(loan);
		c.addPayment(p);
		loan.applyPayment(p);
		person.addContribution(c);
		paymentService.updatePayment(p);
		loanService.updateLoan(loan);
		personService.updatePerson(person);
		borrowerService.updateBorrower(borrower);
		//refresh the session
		model.addAttribute("borrower", borrowerService.getBorrower(borrower.getPerson()));
		model.addAttribute("person", borrower.getPerson());
		return HubController.borrower(model);
	}
}
