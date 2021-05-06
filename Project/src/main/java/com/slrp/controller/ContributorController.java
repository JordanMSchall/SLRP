package com.slrp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.slrp.beans.ProfileType;
import com.slrp.model.Borrower;
import com.slrp.model.Contribution;
import com.slrp.model.Loan;
import com.slrp.model.Payment;
import com.slrp.model.PendingPayment;
import com.slrp.model.Person;
import com.slrp.service.BorrowerService;
import com.slrp.service.LoanService;
import com.slrp.service.PaymentService;
import com.slrp.service.PersonService;
import com.slrp.service.ServicerService;

@SessionAttributes({"person", "borrower"})
@Controller
public class ContributorController {
	private static final Logger logger = LoggerFactory.getLogger(ContributorController.class);

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
	
	
	@RequestMapping("/makeContribution")
	public String makeContribution(@SessionAttribute("person") Person person, @SessionAttribute("borrower") Borrower borrower, @RequestParam String amount,
			@RequestParam String cardNumber, @RequestParam String cvv, @RequestParam String billingZip, Model model) {
		Contribution c = new Contribution();
		c.setAmount(amount);
		Payment p = new Payment();
		p.setAmount(amount);
		paymentService.createPayment(p);
		c.addPayment(p);
		paymentService.createContribution(c);
		p.setContribution(c);
		Loan l = loanService.findRandomLoan();
		if ( l == null ) {
			PendingPayment pp = new PendingPayment(p);
			paymentService.makePending(pp);
		}
		else {
			l.applyPayment(p);
			loanService.updateLoan(l);
		}
		person.addContribution(c);
		paymentService.updatePayment(p);	
		personService.updatePerson(person);
		borrowerService.updateBorrower(borrower);
		//refresh the session
		model.addAttribute("borrower", borrowerService.getBorrower(borrower.getPerson()));
		model.addAttribute("person", borrower.getPerson());
		switch (person.getUser().getType()) {
		case ProfileType.SCHOOL:
			return HubController.school(model);
		case ProfileType.BORROWER:
			model.addAttribute("borrower", borrower);
			return HubController.borrower(model);
		case ProfileType.CONTRIBUTOR:
			return HubController.contributor(model);
		}
		return "index";
	}
}
