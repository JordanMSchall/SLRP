package com.slrp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloWorldController {
	
	@RequestMapping("/")
	public String index() {
		return "<b>Hello!<b>";
	}

}
