package com.slrp.controller;

import com.slrp.api.model.Contributor;
import com.slrp.api.model.Student;
import com.slrp.util.DatabaseUtil;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HubController {

	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		// Jordans controller
		// map java entity
		String [] messages = {"Hello", "World"};
		model.put("messages", messages);
		return "index";
	}

	@RequestMapping("/index")
	public String index2(Map<String, Object> model) {
		// Jordans controller
		// map java entity
		String [] messages = {"Hello", "World"};
		model.put("messages", messages);
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(Map<String, Object> model) {
		// User user = go to database and check if username exists
		// if ( user == null )
			//return "login";
		// verify pw
		// User
		String userType = ""; // get off request
		switch(userType) {
		case  "student":
			return student(model);
		}
		return "index";
	}
	
	@RequestMapping("/student")
	public String student(Map<String, Object> model) {
		Student stud = DatabaseUtil.getStudent();
		//model.put("loans", a.getLoans());
		model.put("student", stud);
		return "student";
	}
	
	@RequestMapping("/student_signup")
	public String studentSignUp(Map<String, Object> model) {
		return "student";
	}
	
	
	@RequestMapping("/contributor")
	public String contributor(Map<String,Object> model) {
		
		Contributor c = DatabaseUtil.createContributor();		
		model.put("name", c.getName());
		model.put("contactInfo", c.getContactInfo());
		model.put("address", c.getAddress());	
		model.put("contributions", c.getContributions());
		
		return "contributor";
	}
	

}
