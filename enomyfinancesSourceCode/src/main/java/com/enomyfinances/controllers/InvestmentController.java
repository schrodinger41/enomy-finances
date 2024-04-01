package com.enomyfinances.controllers;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.enomyfinances.models.User;
import com.enomyfinances.models.UserInvestment;
import com.enomyfinances.repository.UserInvestmentRepository;
import com.enomyfinances.repository.UserRepository;

@Controller
public class InvestmentController {

    @Autowired
    private UserInvestmentRepository investmentRepository;
   
    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping(value = "/investmentspage", method = RequestMethod.GET)
    public String showCurrencyConversionPage() {
        return "investmentspage";
    }
    
    @GetMapping("/investment")
    public String showInvestmentForm(Model model) {
        model.addAttribute("investment", new UserInvestment());
        return "investmentform";
    }
    
    @PostMapping("/showresults")
    public String showResults(@ModelAttribute("investment") UserInvestment userInvestment, Model model, HttpServletRequest req, HttpServletResponse res) {
        calculateInvestmentDetails(userInvestment);
        
        String userEmail = getLoggedInUserEmail(req);
        System.out.println("User Email from Session: " + userEmail);
        User user = userRepository.findByEmail(userEmail);
        
        userInvestment.setUser(user);
        userInvestment.setUserId(user.getUserId()); // Set the userId
        
        // Validate minimum monthly investment and initial lump sum
        if (!isValidInvestment(userInvestment)) {
            model.addAttribute("investmentType", userInvestment.getInvestmentType());
            model.addAttribute("investmentError", "Invalid investment. Please check minimum requirements.");
            return "investmentspage";
        }
        
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String formattedOneYearReturn = decimalFormat.format(userInvestment.getOneYearReturn());
        String formattedFiveYearReturn = decimalFormat.format(userInvestment.getFiveYearsReturn());
        String formattedTenYearReturn = decimalFormat.format(userInvestment.getTenYearsReturn());
        
        String formattedOneYearProfit = decimalFormat.format(userInvestment.getOneyeartotalprofit());
        String formattedFiveYearProfit = decimalFormat.format(userInvestment.getFiveyeartotalprofit());
        String formattedTenYearProfit = decimalFormat.format(userInvestment.getTenyeartotalprofit());

        String formattedOneYearFees = decimalFormat.format(userInvestment.getOneyeartotalfees());
        String formattedFiveYearFees = decimalFormat.format(userInvestment.getFiveyeartotalfees());
        String formattedTenYearFees = decimalFormat.format(userInvestment.getTenyeartotalfees());
        
        String formattedOneYearTaxes = decimalFormat.format(userInvestment.getOneyeartotaltaxes());
        String formattedFiveYearTaxes = decimalFormat.format(userInvestment.getFiveyeartotaltaxes());
        String formattedTenYearTaxes = decimalFormat.format(userInvestment.getTenyeartotaltaxes());
        
        // Set attributes for displaying in JSP
        req.setAttribute("investmentType", userInvestment.getInvestmentType());
        req.setAttribute("initialLumpSum", userInvestment.getInitialLumpSum());
        req.setAttribute("monthlyInvestment", userInvestment.getMonthlyInvestment());

        // Results attributes
        req.setAttribute("oneYearReturn", userInvestment.getOneYearReturn());
        req.setAttribute("fiveYearsReturn", userInvestment.getFiveYearsReturn());
        req.setAttribute("tenYearsReturn", userInvestment.getTenYearsReturn());

        req.setAttribute("oneYearProfit", userInvestment.getOneyeartotalprofit());
        req.setAttribute("fiveYearsProfit", userInvestment.getFiveyeartotalprofit());
        req.setAttribute("tenYearsProfit", userInvestment.getTenyeartotalprofit());
        
        req.setAttribute("oneYearFees", userInvestment.getOneyeartotalfees());
        req.setAttribute("fiveYearsFees", userInvestment.getFiveyeartotalfees());
        req.setAttribute("tenYearsFees", userInvestment.getTenyeartotalfees());
        
        req.setAttribute("oneYearTaxes", userInvestment.getOneyeartotaltaxes());
        req.setAttribute("fiveYearsTaxes", userInvestment.getFiveyeartotaltaxes());
        req.setAttribute("tenYearsTaxes", userInvestment.getTenyeartotaltaxes());
        
        req.setAttribute("formattedOneYearReturn", formattedOneYearReturn);
        req.setAttribute("formattedFiveYearReturn", formattedFiveYearReturn);
        req.setAttribute("formattedTenYearReturn", formattedTenYearReturn);

        req.setAttribute("formattedOneYearProfit", formattedOneYearProfit);
        req.setAttribute("formattedFiveYearProfit", formattedFiveYearProfit);
        req.setAttribute("formattedTenYearProfit", formattedTenYearProfit);
        
        req.setAttribute("formattedOneYearFees", formattedOneYearFees);
        req.setAttribute("formattedFiveYearFees", formattedFiveYearFees);
        req.setAttribute("formattedTenYearFees", formattedTenYearFees);

        req.setAttribute("formattedOneYearTaxes", formattedOneYearTaxes);
        req.setAttribute("formattedFiveYearTaxes", formattedFiveYearTaxes);
        req.setAttribute("formattedTenYearTaxes", formattedTenYearTaxes);

        // Additional attributes if needed
        investmentRepository.save(userInvestment);
        req.setAttribute("showResults", true);

        return "investmentspage";
    }


    private String getLoggedInUserEmail(HttpServletRequest request) {
        // Retrieve user details from the security context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {
            // Get the email from UserDetails
            return ((UserDetails) authentication.getPrincipal()).getUsername();
        }

        // Return null if user details are not available
        return null;
    }

    private void calculateInvestmentDetails(UserInvestment userInvestment) {
        switch (userInvestment.getInvestmentType()) {
            case "Basic Savings Plan": 
                userInvestment.setInvestmentType("Basic Savings Plan");
                calculateBasicSavingsPlan(userInvestment);
                break;
            case "Savings Plan Plus":
                userInvestment.setInvestmentType("Savings Plan Plus");
                calculateSavingsPlanPlus(userInvestment);
                break;
            case "Managed Stock Investments": 
                userInvestment.setInvestmentType("Managed Stock Investments");
                calculateManagedStockInvestments(userInvestment);
                break;
        }
    }
    
    private boolean isValidInvestment(UserInvestment userInvestment) {
        switch (userInvestment.getInvestmentType()) {
            case "Basic Savings Plan":
                return userInvestment.getMonthlyInvestment() >= 50;
            case "Savings Plan Plus":
                return userInvestment.getMonthlyInvestment() >= 50 && userInvestment.getInitialLumpSum() >= 300;
            case "Managed Stock Investments":
                return userInvestment.getMonthlyInvestment() >= 150 && userInvestment.getInitialLumpSum() >= 1000;
            default:
                return false;
        }
    }

    private void calculateBasicSavingsPlan(UserInvestment userInvestment) {
        // Set maximum and minimum returns for 1 year, 5 years, and 10 years
        userInvestment.setOneYearReturn(calculateReturn(userInvestment.getInitialLumpSum(), 0.012, userInvestment.getMonthlyInvestment(), 12));
        userInvestment.setFiveYearsReturn(calculateReturn(userInvestment.getInitialLumpSum(), 0.024, userInvestment.getMonthlyInvestment(), 12 * 5));
        userInvestment.setTenYearsReturn(calculateReturn(userInvestment.getInitialLumpSum(), 0.024, userInvestment.getMonthlyInvestment(), 12 * 10));

        // Set total profit, total fees, and total taxes for each time frame (assuming 0% tax)
        userInvestment.setOneyeartotalprofit(userInvestment.getOneYearReturn());
        userInvestment.setFiveyeartotalprofit(userInvestment.getFiveYearsReturn());
        userInvestment.setTenyeartotalprofit(userInvestment.getTenYearsReturn());

        userInvestment.setOneyeartotalfees(calculateFee(userInvestment.getOneYearReturn(), 0.0025));
        userInvestment.setFiveyeartotalfees(calculateFee(userInvestment.getFiveYearsReturn(), 0.0025));
        userInvestment.setTenyeartotalfees(calculateFee(userInvestment.getTenYearsReturn(), 0.0025));

        userInvestment.setOneyeartotaltaxes(0); // Assuming 0% tax
        userInvestment.setFiveyeartotaltaxes(0);
        userInvestment.setTenyeartotaltaxes(0);
    }

    private void calculateSavingsPlanPlus(UserInvestment userInvestment) {
        // Set maximum and minimum returns for 1 year, 5 years, and 10 years
        userInvestment.setOneYearReturn(calculateReturn(userInvestment.getInitialLumpSum(), 0.03, userInvestment.getMonthlyInvestment(), 12));
        userInvestment.setFiveYearsReturn(calculateReturn(userInvestment.getInitialLumpSum(), 0.055, userInvestment.getMonthlyInvestment(), 12 * 5));
        userInvestment.setTenYearsReturn(calculateReturn(userInvestment.getInitialLumpSum(), 0.055, userInvestment.getMonthlyInvestment(), 12 * 10));

        // Set total profit, total fees, and total taxes for each time frame (assuming 10% tax on profits above £12,000)
        userInvestment.setOneyeartotalprofit(userInvestment.getOneYearReturn());
        userInvestment.setFiveyeartotalprofit(userInvestment.getFiveYearsReturn());
        userInvestment.setTenyeartotalprofit(userInvestment.getTenYearsReturn());

        userInvestment.setOneyeartotalfees(calculateFee(userInvestment.getOneYearReturn(), 0.003));
        userInvestment.setFiveyeartotalfees(calculateFee(userInvestment.getFiveYearsReturn(), 0.003));
        userInvestment.setTenyeartotalfees(calculateFee(userInvestment.getTenYearsReturn(), 0.003));

        userInvestment.setOneyeartotaltaxes(calculateTax(userInvestment.getOneYearReturn(), 0.1, 12000));
        userInvestment.setFiveyeartotaltaxes(calculateTax(userInvestment.getFiveYearsReturn(), 0.1, 12000));
        userInvestment.setTenyeartotaltaxes(calculateTax(userInvestment.getTenYearsReturn(), 0.1, 12000));
    }

    private void calculateManagedStockInvestments(UserInvestment userInvestment) {
        // Set maximum and minimum returns for 1 year, 5 years, and 10 years
        userInvestment.setOneYearReturn(calculateReturn(userInvestment.getInitialLumpSum(), 0.04, userInvestment.getMonthlyInvestment(), 12));
        userInvestment.setFiveYearsReturn(calculateReturn(userInvestment.getInitialLumpSum(), 0.23, userInvestment.getMonthlyInvestment(), 12 * 5));
        userInvestment.setTenYearsReturn(calculateReturn(userInvestment.getInitialLumpSum(), 0.23, userInvestment.getMonthlyInvestment(), 12 * 10));

        // Set total profit, total fees, and total taxes for each time frame (assuming 10% tax on profits above £12,000 and 20% tax on profits above £40,000)
        userInvestment.setOneyeartotalprofit(userInvestment.getOneYearReturn());
        userInvestment.setFiveyeartotalprofit(userInvestment.getFiveYearsReturn());
        userInvestment.setTenyeartotalprofit(userInvestment.getTenYearsReturn());

        userInvestment.setOneyeartotalfees(calculateFee(userInvestment.getOneYearReturn(), 0.013));
        userInvestment.setFiveyeartotalfees(calculateFee(userInvestment.getFiveYearsReturn(), 0.013));
        userInvestment.setTenyeartotalfees(calculateFee(userInvestment.getTenYearsReturn(), 0.013));

        userInvestment.setOneyeartotaltaxes(calculateTax(userInvestment.getOneYearReturn(), 0.1, 12000));
        userInvestment.setFiveyeartotaltaxes(calculateTax(userInvestment.getFiveYearsReturn(), 0.1, 12000));
        userInvestment.setTenyeartotaltaxes(calculateTax(userInvestment.getTenYearsReturn(), 0.2, 40000));
    }

    private double calculateReturn(double initialLumpSum, double annualRate, double monthlyInvestment, int months) {
        double totalInvestment = initialLumpSum + (monthlyInvestment * months);
        return totalInvestment * Math.pow(1 + annualRate / 12, months / 12.0) - totalInvestment;
    }

    private double calculateFee(double totalReturn, double feeRate) {
        return totalReturn * feeRate;
    }

    private double calculateTax(double totalProfit, double taxRate, double taxableThreshold) {
        double taxableProfit = Math.max(0, totalProfit - taxableThreshold);
        return taxableProfit * taxRate;
    }
    
}
