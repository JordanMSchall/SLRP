package com.slrp.controller;

import org.springframework.web.bind.annotation.RestController;

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
	
	@RequestMapping("/student")
	public String student(Map<String, Object> model) {
		Student a = DatabaseUtil.getStudent();
		//model.put("loans", a.getLoans());
		model.put("student",a.getName());
		return "student";
	}
	
	
	@RequestMapping("/t")
	public String test() {
		// Jordans controller
		return "test";
	}

}
