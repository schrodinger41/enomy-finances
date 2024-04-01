package com.enomyfinances.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;

import com.enomyfinances.service.UserService;
@Controller
public class RegistrationController {
	private final UserService clientService;

    @Autowired
    public RegistrationController(UserService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/enomyfinancesSourceCode/registerprocess")
    public ModelAndView registerClient(@RequestParam String firstName,
                                       @RequestParam String lastName,
                                       @RequestParam String email,
                                       @RequestParam String password,
                                       @RequestParam int phoneNumber,
                                       HttpSession session,
                                       RedirectAttributes redirectAttributes) {
        try {
            // Register client using service method
            clientService.registerNewClient(firstName, lastName, email, password, phoneNumber);
            session.setAttribute("isLogin", true);
            return new ModelAndView("redirect:/thankyou");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return new ModelAndView("redirect:/register");
        }
    }

}
