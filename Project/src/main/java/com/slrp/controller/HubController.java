package com.slrp.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HubController {
	
	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		// Jordans controller
		// map java entity
		model.put("message", "HowToDoInJava Reader !!");
		return "index";
	}
	
	@RequestMapping("/student")
	public String student() {
		// Jordans controller
		return "Greetings from Student!";
	}
	
	@RequestMapping("/contributor")
	public String contributor() {
		return "contributor";
	}
	
	@RequestMapping("/t")
	public String test() {
		// Jordans controller
		return "test";
	}

}
