package com.slrp.controller;

import com.slrp.beans.ProfileType;
import com.slrp.beans.service.ProfileService;
import com.slrp.model.Borrower;
import com.slrp.model.ContactInfo;
import com.slrp.model.Organization;
import com.slrp.model.Person;
import com.slrp.model.School;
import com.slrp.model.User;
import com.slrp.util.RecordGenerator;

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

@Controller
public class HubController {
	private static final Logger logger = LoggerFactory.getLogger(HubController.class);

	@Autowired
	ProfileService profileService;

	@RequestMapping("/")
	public String index(Model model) {

		if (model.getAttribute("user") == null) 
			model.addAttribute("user", new User());
		if (model.getAttribute("person") == null)
			model.addAttribute("person", new Person());
		if (model.getAttribute("contactInfo") == null)
			model.addAttribute("contactInfo", new ContactInfo());
		if (model.getAttribute("org") == null) 
			model.addAttribute("org", new Organization());

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
	public String login(Model model) {
		// User user = go to database and check if username exists
		// if ( user == null )
		// return "login";
		// verify pw
		// User
//		String userType = ""; // get off request
//		switch(userType) {
//		case  "student":
//			return student(model);
//		}

		return "index";
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

		//User user = (User) model.getAttribute("user");
		//user.setPerson(p);
		model.addAttribute("message", "FUCK");
		model.addAttribute("person", p);
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
			BindingResult result, Model model) {
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
			Borrower b = new Borrower(user, person, contactInfo);
			model.addAttribute("user", user);
			model.addAttribute("person", new Person(user, contactInfo));
			model.addAttribute("borrower", b);
			profileService.createProfile(b);
			return borrower(model);
		case ProfileType.CONTRIBUTOR:
			model.addAttribute("user", user);
			// model.put("contributor", contributor);
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
//		// borrower
//		Person p = RecordGenerator.generatePerson();
//		RecordGenerator.generateContactInfo(p);
//		RecordGenerator.generatePersonContribution(p);
//		RecordGenerator.generatePersonContribution(p);
//		model.put("name", p.getFullName());
//		model.put("contactInfo", p.getContactInfo());
//		model.put("address", p.getContactInfo().getAddress());
//		model.put("contributions", p.getContributions());

		return "contributor";
	}

}
