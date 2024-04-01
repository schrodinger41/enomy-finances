package com.enomyfinances.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.enomyfinances.service.ForgotPasswordService;

@Controller
public class LoginController {
	
	
	
	@GetMapping("/login")
	public String showLoginPage(@RequestParam(name = "error", required = false) String error, Model model) {
	    if (error != null) {
	    	model.addAttribute("loginError", "Invalid email or password. Please try again");
	    }
		return "login";
	}

	@GetMapping("/welcome")
	public String showWelcomePage(HttpServletRequest request, HttpServletResponse response) {
	    HttpSession session = request.getSession();
	    session.setAttribute("isLogin", true);
	    return "welcome"; 
	}
	
	@GetMapping("/")
    public String showIndexPage() {
        return "index";
    }
	
	@RequestMapping(value = "/aboutuspage", method = RequestMethod.GET)
    public String showAboutUsPage() {
        return "aboutuspage";
    }
	
	@Autowired
    private ForgotPasswordService forgotPasswordService;
    
    @RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
    public String showForgotPasswordPage() {
        return "forgotpassword";
    }
    
    @RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
    public String changePassword(@RequestParam("emailAddress") String email,
                                 @RequestParam("password") String password,
                                 @RequestParam("passwordConfirmation") String passwordConfirmation,
                                 Model model) {

        String resultMessage = forgotPasswordService.changePassword(email, password, passwordConfirmation);
        model.addAttribute("message", resultMessage);

        if ("Password changed successfully".equals(resultMessage)) {
            return "login";
        } else {
            return "forgotpassword";
        }
    }
}

	
	

