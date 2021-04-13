package com.slrp.controller;

import com.slrp.api.model.Contributor;
import com.slrp.api.model.Contribution;
import com.slrp.util.DatabaseUtil;
import java.util.ArrayList;
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
	public String student() {
		// Jordans controller
		return "Greetings from Student!";
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
	
	@RequestMapping("/t")
	public String test() {
		// Jordans controller
		return "test";
	}

}
