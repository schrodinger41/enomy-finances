package com.enomyfinances.controllers;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.enomyfinances.models.CurrencyConversion;
import com.enomyfinances.models.User;
import com.enomyfinances.models.UserInvestment;
import com.enomyfinances.repository.UserInvestmentRepository;
import com.enomyfinances.repository.UserRepository;
import com.enomyfinances.service.CurrencyConversionService;
import com.enomyfinances.service.UserServiceImpl;
@Controller
public class DashboardController {
	
	private final UserRepository userRepository;
    private final CurrencyConversionService conversionService;
    private final UserInvestmentRepository investmentRepository;
    private final UserServiceImpl userService;

    public DashboardController(UserRepository userRepository, CurrencyConversionService conversionService, UserInvestmentRepository investmentRepository, UserServiceImpl userService) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
		this.investmentRepository = investmentRepository;
		this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model, Authentication authentication) {
        String email = authentication.getName();
        
        User user = userRepository.findByEmail(email);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());

        // Retrieve saved currency conversions for the user
        List<CurrencyConversion> savedConversions = conversionService.findAllSavedConversions(user.getEmail());
        model.addAttribute("savedConversions", savedConversions);
        
        List<UserInvestment> userInvestments = investmentRepository.findByUserId(user.getUserId());
        model.addAttribute("userInvestments", userInvestments);
        
        List<User> users = userService.listAll();
        model.addAttribute("user", users);
        
        return "dashboard";
    }
    
    @GetMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userRepository.deleteById(id);
        return "redirect:/dashboard"; 
    }
}
