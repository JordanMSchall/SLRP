package com.slrp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.slrp.model.Borrower;
import com.slrp.model.Loan;
import com.slrp.model.Servicer;
import com.slrp.service.BorrowerService;
import com.slrp.service.LoanService;
import com.slrp.service.PaymentService;
import com.slrp.service.PersonService;
import com.slrp.service.ServicerService;

@SessionAttributes({"person", "school"})
@Controller
public class SchoolController {

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
	
	@RequestMapping("/addstudent")
	public String login(@SessionAttribute("person") Person person, @SessionAttribute("school") School school, @RequestParam String loanId,
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
}
