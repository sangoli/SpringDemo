package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class firstController {

	@GetMapping(value="/text")
	public String render() {
		return "Welcome to spring boot";
	}
	
}