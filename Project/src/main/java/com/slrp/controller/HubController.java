package com.slrp.controller;

import com.slrp.api.model.Borrower;
import com.slrp.api.model.Organization;
import com.slrp.api.model.Person;
import com.slrp.api.model.School;
import com.slrp.util.DatabaseUtil;
import com.slrp.util.RecordGenerator;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HubController {

	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		// Jordans controller
		// map java entity
		String[] messages = { "Hello", "World" };
		model.put("messages", messages);
		return "index";
	}

	@RequestMapping("/index")
	public String index2(Map<String, Object> model) {
		// Jordans controller
		// map java entity
		String[] messages = { "Hello", "World" };
		model.put("messages", messages);
		return "index";
	}

	@RequestMapping("/login")
	public String login(Map<String, Object> model) {
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
	public String borrower(Map<String, Object> model) {
		// borrower
		Person p = RecordGenerator.generatePerson();
		RecordGenerator.generateContactInfo(p);

		// school contact
		Person p2 = RecordGenerator.generatePerson();
		RecordGenerator.generateContactInfo(p);

		School s = RecordGenerator.generateSchool();
		s.setContact(p2.getContactInfo());

		Borrower borrower = RecordGenerator.generateBorrower(p, s);

		model.put("borrower", borrower);
		model.put("name", borrower.getPerson().getFullName());
		model.put("address", borrower.getPerson().getContactInfo().getAddress());
		return "borrower";
	}

	@RequestMapping("/student_signup")
	public String studentSignUp(Map<String, Object> model) {
		return "student";
	}

	@RequestMapping("/contributor")
	public String contributor(Map<String, Object> model) {
		// borrower
		Person p = RecordGenerator.generatePerson();
		RecordGenerator.generateContactInfo(p);
		RecordGenerator.generatePersonContribution(p);
		RecordGenerator.generatePersonContribution(p);
		model.put("name", p.getFullName());
		model.put("contactInfo", p.getContactInfo());
		model.put("address", p.getContactInfo().getAddress());
		model.put("contributions", p.getContributions());

		return "contributor";
	}

}
