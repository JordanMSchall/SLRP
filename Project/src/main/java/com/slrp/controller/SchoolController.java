package com.slrp.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.slrp.model.Borrower;
import com.slrp.model.ContactInfo;
import com.slrp.model.Loan;
import com.slrp.model.Person;
import com.slrp.model.School;
import com.slrp.service.BorrowerService;
import com.slrp.service.LoanService;
import com.slrp.service.OrgService;
import com.slrp.service.PaymentService;
import com.slrp.service.PersonService;
import com.slrp.service.ServicerService;

@SessionAttributes({ "person", "school" })
@Controller
public class SchoolController {

	@Autowired
	BorrowerService borrowerService;

	@Autowired
	LoanService loanService;
	
	@Autowired
	OrgService orgService;

	@Autowired
	ServicerService servicerService;

	@Autowired
	PersonService personService;

	@Autowired
	PaymentService paymentService;

	@RequestMapping("/addstudent")
	public String login(@SessionAttribute("person") Person person, @SessionAttribute("school") School school,
			@RequestParam String firstName, @RequestParam String lastName, @RequestParam String primaryPhone,
			@RequestParam String loanId, @RequestParam String loanAmount, @RequestParam String cohortYear,@RequestParam String servicer,
			Model model) {
		Person per = new Person();
		per.setFirstName(firstName);
		per.setLastName(lastName);
		personService.createPerson(per);
		ContactInfo ci = new ContactInfo();
		ci.setPerson(per);
		ci.setPrimaryPhone(primaryPhone);
		Borrower b = new Borrower();
		b.setPerson(per);
		b.setSchool(school);
		b.setCohortYear(Integer.parseInt(cohortYear));
		Loan l = new Loan();
		l.setLoanDoeId(loanId);
		l.setAmount(loanAmount);
		loanService.createLoan(l);
		l.setBorrower(b);
		b.addLoan(l);
		borrowerService.createBorrower(b);
		//l.setServicer()
		loanService.updateLoan(l);
		school.addBorrower(b);
		orgService.updateSchool(school);
		model.addAttribute("person", person);
		model.addAttribute("school", school);
		personService.saveContact(ci);
		return HubController.school(model);
	}

	@RequestMapping("/uploadfile")
	public String uploadFile(
			@RequestParam File file, Model model) {

		return HubController.school(model);
	}

	@RequestMapping("/email")
	public String email(@SessionAttribute("person") Person person, @SessionAttribute("school") School school,
			@RequestParam String emailAddress, @RequestParam String message, Model model) {

		return HubController.school(model);
	}
}
