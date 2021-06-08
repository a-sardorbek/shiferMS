package com.bek.cement2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String homePage() {
		return "home";
	}
	
	 @RequestMapping("/login")
	    public String login(){
	        return "login";
	    }
	//12332132


}
