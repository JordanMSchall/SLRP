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
import com.slrp.service.BorrowerService;
import com.slrp.service.LoanService;
import com.slrp.service.OrgService;
import com.slrp.service.PersonService;
import com.slrp.service.UserService;

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
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({ "person", "borrower", "school", "contributor" })
@Controller
public class HubController {
	private static final Logger logger = LoggerFactory.getLogger(HubController.class);

	@Autowired
	UserService userService;

	@Autowired
	LoanService loanService;

	@Autowired
	BorrowerService borrowerService;

	@Autowired
	PersonService personService;

	@Autowired
	OrgService orgService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("contactInfo", new ContactInfo());
		model.addAttribute("org", new Organization());
		model.addAttribute("person", new Person());
		return "index";
	}

	@RequestMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, Model model) {
		User user = userService.verifyUser(username, password);
		if (user != null) {
			Person person = user.getPerson();
			ContactInfo contactInfo = person.getContactInfo();
			switch (user.getType()) {
			case ProfileType.SCHOOL:
				model.addAttribute("person", person);
				School school = orgService.getSchoolByContactInfo(person.getContactInfo());
				model.addAttribute("school", school);
				return school(model);
			case ProfileType.BORROWER:
				person.setContactInfo(contactInfo);
				Borrower b = borrowerService.getBorrower(person);
				model.addAttribute("person", person);
				model.addAttribute("borrower", b);
				return borrower(model);

			case ProfileType.CONTRIBUTOR:
				model.addAttribute("user", person.getUser());
				model.addAttribute("contactInfo", person.getContactInfo());
				model.addAttribute("contributions", person.getContributions());
				return contributor(model);
			}
		}
		return index(model);
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(@Validated @ModelAttribute("user") User user,
			@Validated @ModelAttribute("person") Person person,
			@Validated @ModelAttribute("contactInfo") ContactInfo contactInfo,
			@Validated @ModelAttribute("org") Organization org,
			@Validated @ModelAttribute("contribution") Contribution contribution,
			@Validated @ModelAttribute("loan") Loan loan, BindingResult result, Model model) {

		if (userService.checkUsername(user.getUsername()) != null)
			return index(model);

		switch (user.getType()) {
		case ProfileType.SCHOOL:
			person.setUser(user);
			orgService.createOrg(org);
			personService.saveContact(contactInfo);
			person.setContactInfo(contactInfo);
			personService.createPerson(person);
			org.setContactInfo(contactInfo);
			School s = new School();
			s.setName(org.getName());
			s.setContact(contactInfo);
			orgService.createSchool(s);
			model.addAttribute("school", s);
			userService.createProfile(person);
			return school(model);
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
			model.addAttribute("person",person);
			userService.createProfile(c);
			return contributor(model);

		}
		return "index";
	}

	// page rendering calls
	@RequestMapping("/contributor")
	public static String contributor(Model model) {
		return "contributor";
	}

	@RequestMapping("/borrower")
	public static String borrower(Model model) {
		return "borrower";
	}

	@RequestMapping("/school")
	public static String school(Model model) {
		return "school";
	}

}
