package com.slrp.api.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.slrp.api.model.Example;

@RestController
public class ExampleController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/example")
	public Example greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Example(counter.incrementAndGet(), String.format(template, name));
	}
}