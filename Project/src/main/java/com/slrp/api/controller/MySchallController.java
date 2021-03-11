package com.slrp.api.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.slrp.api.model.Schall;

@RestController
public class MySchallController {

	private static final String template = "Jordan is a %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/schalligans")
	public Schall getSchall(@RequestParam(value = "adjective", defaultValue = "World") String adjective , @RequestParam(value = "verb", defaultValue = "slow") String verb ){
		return new Schall(counter.incrementAndGet(), String.format(template, adjective), verb);
	}
	
//	// handle post mapping aka an insert
//	@PostMapping("/schalligans")
//	public Schall postSchall(@RequestParam(value = "adjective", defaultValue = "World") String adjective) {
//		//return new Schall(counter.incrementAndGet(), String.format(template, adjective));
//		return null 
//	}
//	
//	// handle put mapping aka an insert
//	@PutMapping("/schalligans")
//	public Schall updateSchall(@RequestParam(value = "adjective", defaultValue = "World") String adjective) {
//		//return new Schall(counter.incrementAndGet(), String.format(template, adjective));
//	}
//
//	// handle delete mapping aka an insert
//	@DeleteMapping("/schalligans")
//	@ResponseStatus(value = HttpStatus.NO_CONTENT)
//	public Schall deleteSchall(@RequestParam(value = "adjective", defaultValue = "World") String adjective) {
//		// return 204 no content
//		return null;
//	}


}