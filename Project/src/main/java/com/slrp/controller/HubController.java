package com.slrp.controller;

import com.slrp.beans.ProfileType;
import com.slrp.model.Borrower;
import com.slrp.model.ContactInfo;
import com.slrp.model.Contribution;
import com.slrp.model.Contributor;
import com.slrp.model.Loan;
import com.slrp.model.Organization;
import com.slrp.model.Person;
import com.slrp.model.School;
import com.slrp.model.User;
import com.slrp.service.LoanService;
import com.slrp.service.UserService;
import com.slrp.util.RecordGenerator;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("person")
@Controller
public class HubController {
	private static final Logger logger = LoggerFactory.getLogger(HubController.class);

	@Autowired
	UserService userService;

	@Autowired
	LoanService loanService;

	@RequestMapping("/")
	public String index(Model model) {

		if (model.getAttribute("user") == null)
			model.addAttribute("user", new User());
		if (model.getAttribute("contactInfo") == null)
			model.addAttribute("contactInfo", new ContactInfo());
		if (model.getAttribute("org") == null)
			model.addAttribute("org", new Organization());
		if (model.getAttribute("person") == null)
			model.addAttribute("person", new Person());

		if (model.getAttribute("user") != null && ((User) model.getAttribute("user")).getType() != null) {
			String profType = ((User) model.getAttribute("user")).getType();
			switch (profType) {
			case ProfileType.SCHOOL:
				return school(model);
			case ProfileType.BORROWER:
				return borrower(model);
			case ProfileType.CONTRIBUTOR:
				return contributor(model);
			}
		}

		return "index";
	}

	@RequestMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, Model model) {
		User user = userService.verifyUser(username, password);
		if (user != null) {
			Person person = user.getPerson();
			ContactInfo contactInfo = person.getContactInfo();
			switch (user.getType()) {
			// TODO: Ashley solution
//					not implemented
//					case ProfileType.SCHOOL:
//						model.addAttribute("user", user);
//						return school(model);
			case ProfileType.BORROWER:
				person.setUser(user);
				person.setContactInfo(contactInfo);
				Borrower b = new Borrower(user, person, contactInfo);
				model.addAttribute("user", user);
				model.addAttribute("person", person);
				model.addAttribute("borrower", b);
				userService.createProfile(b);
				return borrower(model);

			case ProfileType.CONTRIBUTOR:
//				user = new User(user);
//				person.setUser(user);
//				person.setContactInfo(contactInfo);
//				Contributor c = new Contributor(person);
//				model.addAttribute("contributor", c);
//				model.addAttribute("user", person.getUser());
//				model.addAttribute("contactInfo", person.getContactInfo());
//				model.addAttribute("contribution", contribution);
//				model.addAttribute("loan", loan);
//				userService.createProfile(c);
				return contributor(model);

			}
		}
		return index(model);
	}

	@RequestMapping("/borrower")
	public String borrower(Model model) {
		// borrower
		Person p = RecordGenerator.generatePerson();
		RecordGenerator.generateContactInfo(p);

		// school contact
		Person p2 = RecordGenerator.generatePerson();
		RecordGenerator.generateContactInfo(p);

		School s = RecordGenerator.generateSchool();
		s.setContact(p2.getContactInfo());

		Borrower borrower = RecordGenerator.generateBorrower(p, s);

		// User user = (User) model.getAttribute("user");
		// user.setPerson(p);
		model.addAttribute("message", "nice");
		model.addAttribute("contactInfo", p.getContactInfo());
		model.addAttribute("user", new User());
		model.addAttribute("borrower", borrower);
		model.addAttribute("name", borrower.getPerson().getFullName());
		model.addAttribute("address", borrower.getPerson().getContactInfo().getAddress());
		return "borrower";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(@Validated @ModelAttribute("user") User user,
			@Validated @ModelAttribute("person") Person person,
			@Validated @ModelAttribute("contactInfo") ContactInfo contactInfo,
			@Validated @ModelAttribute("org") Organization org,
			@Validated @ModelAttribute("contribution") Contribution contribution,
			@Validated @ModelAttribute("loan") Loan loan, BindingResult result, Model model) {
		logger.debug("\n Found user!\n" + user.toString() + "\n");
		logger.debug("\n Found person!\n" + person.toString() + "\n");
		logger.debug("\n Found contactInfo!\n" + contactInfo.toString() + "\n");

		switch (user.getType()) {
// TODO: Ashley solution
//		not implemented
//		case ProfileType.SCHOOL:
//			model.addAttribute("user", user);
//			return school(model);
		case ProfileType.BORROWER:
			person.setUser(user);
			person.setContactInfo(contactInfo);
			Borrower b = new Borrower(user, person, contactInfo);
			model.addAttribute("user", user);
			model.addAttribute("person", person);
			model.addAttribute("borrower", b);
			userService.createProfile(b);
			return borrower(model);

		case ProfileType.CONTRIBUTOR:
			user = new User(user);
			person.setUser(user);
			person.setContactInfo(contactInfo);
			Contributor c = new Contributor(person);
			model.addAttribute("contributor", c);
			model.addAttribute("user", person.getUser());
			model.addAttribute("contactInfo", person.getContactInfo());
			model.addAttribute("contribution", contribution);
			model.addAttribute("loan", loan);
			userService.createProfile(c);
			return contributor(model);

		}
		return "index";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUpGet(Model model) {
		return index(model);
	}

	private String school(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping("/contributor")
	public String contributor(Model model) {
		return "contributor";
	}

	@RequestMapping("/makeContribution")
	public String makeContribution(@SessionAttribute("person") Person person, Model model) {
		logger.debug("\n Found person!\n" + person.toString() + "\n");

		switch (person.getUser().getType()) {
		// TODO: Ashley solution
//				not implemented
//				case ProfileType.SCHOOL:
//					model.addAttribute("user", user);
//					return school(model);
		case ProfileType.BORROWER:
			return borrower(model);
		case ProfileType.CONTRIBUTOR:
			if (person.getContributions() != null && !person.getContributions().isEmpty())
				model.addAttribute("contribution", person.getContributions());
			if (loanService.getLoans().spliterator().getExactSizeIfKnown() != 0)
				model.addAttribute("loans", loanService.getLoans());
			Contribution c = new Contribution();
			model.addAttribute("contribution", c);
			return contributor(model);
		}
		return "index";
	}

	@RequestMapping("/outreach")
	public String outreach(@SessionAttribute("person") Person person, @RequestParam String primaryPhone,
			@RequestParam String message, @RequestParam String email, Model model) {
		logger.debug("\n Found person!\n" + person.toString() + "\n");

		switch (person.getUser().getType()) {
		// TODO: Ashley solution
//				not implemented
//				case ProfileType.SCHOOL:
//					model.addAttribute("user", user);
//					return school(model);
		case ProfileType.BORROWER:
			return borrower(model);
		case ProfileType.CONTRIBUTOR:
			if (person.getContributions() != null && !person.getContributions().isEmpty())
				model.addAttribute("contribution", person.getContributions());
			if (loanService.getLoans().spliterator().getExactSizeIfKnown() != 0)
				model.addAttribute("loans", loanService.getLoans());
			Contribution c = new Contribution();
			model.addAttribute("contribution", c);
			return contributor(model);
		}
		return "index";
	}

	@RequestMapping("/viewLoans")
	public String viewLoans(@SessionAttribute("person") Person person, @RequestParam String loan, Model model) {
		logger.debug("\n Found person!\n" + person.toString() + "\n");

		switch (person.getUser().getType()) {
		// TODO: Ashley solution
//				not implemented
//				case ProfileType.SCHOOL:
//					model.addAttribute("user", user);
//					return school(model);
		case ProfileType.BORROWER:
			return borrower(model);
		case ProfileType.CONTRIBUTOR:
			if (person.getContributions() != null && !person.getContributions().isEmpty())
				model.addAttribute("contribution", person.getContributions());
			if (loanService.getLoans().spliterator().getExactSizeIfKnown() != 0)
				model.addAttribute("loans", loanService.getLoans());
			Contribution c = new Contribution();
			model.addAttribute("contribution", c);
			return contributor(model);
		}
		return "index";
	}

}
