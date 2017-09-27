package com.bestcxx.stu.fileup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	@GetMapping(value={"/home","/"})
	public String homePage(){
		return "home";
	}
	
	
	
	
}
