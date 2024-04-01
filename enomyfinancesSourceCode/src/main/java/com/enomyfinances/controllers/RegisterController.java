package com.enomyfinances.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

	 	@GetMapping("/register-error")
	    public String showRegisterError() {
	        return "register";
	    }
	    
	    @GetMapping("/register")
	    public String showRegisterForm() {
	        return "register"; 
	    }
	    
	    @GetMapping("/thankyou")
	    public String showThankyouPage() {
	        return "thankyou"; 
	    }
}
