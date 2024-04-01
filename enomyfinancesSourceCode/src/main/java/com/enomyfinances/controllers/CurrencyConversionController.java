package com.enomyfinances.controllers;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.enomyfinances.service.CurrencyConversionService;

@Controller
public class CurrencyConversionController {
	
    @Autowired
    private CurrencyConversionService conversionService;
    
    @RequestMapping(value = "/currencyconversionpage", method = RequestMethod.GET)
    public String showCurrencyConversionPage() {
        return "currencyconversionpage";
    }
    
    @RequestMapping("/currencyconversion")
    public String convertCurrency(HttpServletRequest req, HttpServletResponse res, Model model) throws IOException, ServletException {
        res.setContentType("text/html;charset=UTF-8");

        try {
            String fromCurrency = req.getParameter("fromCurrency");
            String toCurrency = req.getParameter("toCurrency");
            double amount = Double.parseDouble(req.getParameter("amount"));

            try {
                amount = Double.parseDouble(req.getParameter("amount"));

                // Check if the amount is within the allowed range
                if (amount < 300 || amount > 5000) {
                    req.setAttribute("invalidAmount", true);
                    return "currencyconversionpage";
                }
            } catch (NumberFormatException e) {
                // Handle invalid amount format
                req.setAttribute("invalidAmountFormat", true);
                return "currencyconversionpage";
            }

            // Declare the conversionRate variable
            double conversionRate = getConversionRate(fromCurrency, toCurrency);

            // Check if conversionRate is valid
            if (conversionRate == -1) {
                // Handle invalid conversion rate
                req.setAttribute("conversionSuccess", false);
                return "currencyconversionpage";
            }

            // Get the conversion details
            ConversionDetails conversionDetails = convertCurrency(fromCurrency, toCurrency, amount);

            // Format the finalConvertedAmount to display up to the tenth decimal place
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            String formattedFinalConvertedAmount = decimalFormat.format(conversionDetails.getFinalConvertedAmount());
            String formattedConvertedAmount = decimalFormat.format(conversionDetails.getConvertedAmount());
            
            
            // Determine the fee based on the provided conditions
            double finalConvertedAmount = amount * conversionRate;
            double fee = calculateFee(finalConvertedAmount);
            String formattedFee = decimalFormat.format(fee);
            // Set the result in request attributes
            req.setAttribute("amount", amount);
            req.setAttribute("fromCurrency", fromCurrency);
            req.setAttribute("convertedAmount", conversionDetails.getConvertedAmount());
            req.setAttribute("formattedConvertedAmount", formattedConvertedAmount);
            req.setAttribute("finalConvertedAmount", conversionDetails.getFinalConvertedAmount());
            req.setAttribute("formattedFinalConvertedAmount", formattedFinalConvertedAmount);  // Use this attribute in the JSP
            req.setAttribute("toCurrency", toCurrency);
            req.setAttribute("conversionSuccess", conversionDetails.isConversionSuccess());
            req.setAttribute("conversionSuccess", true);
            req.setAttribute("fee", formattedFee);  // Add this line to include the fee in attributes

            // Forward the request to the JSP page
            return "currencyconversionpage";
        } catch (NumberFormatException e) {
            // Handle invalid input (non-numeric amount)
            req.setAttribute("conversionSuccess", false);
            return "currencyconversionpage";
        }
    }

    private ConversionDetails convertCurrency(String fromCurrency, String toCurrency, double amount) {
        double conversionRate = getConversionRate(fromCurrency, toCurrency);

        if (conversionRate != -1) {
            double convertedAmount = amount * conversionRate;
            double finalConvertedAmount = getFinalConvertedAmount(convertedAmount);
            return new ConversionDetails(true, convertedAmount, finalConvertedAmount);
        } else {
            return new ConversionDetails(false, 0, 0);
        }
    }

    private double getConversionRate(String fromCurrency, String toCurrency) {
    	//february 2, 2024 currency
    	if ("GBP".equals(fromCurrency) && "USD".equals(toCurrency)) {
            return 1.26897; 
        } 
        else if ("GBP".equals(fromCurrency) && "EUR".equals(toCurrency)) {
            return 1.17197; 
        }
        else if ("GBP".equals(fromCurrency) && "BRL".equals(toCurrency)) {
            return 6.26528; 
        }
        else if ("GBP".equals(fromCurrency) && "JPY".equals(toCurrency)) {
            return 186.052; 
        }
        else if ("GBP".equals(fromCurrency) && "JPY".equals(toCurrency)) {
            return 186.052; 
        }
        else if ("GBP".equals(fromCurrency) && "TRY".equals(toCurrency)) {
            return 38.525; 
        }
        else if ("USD".equals(fromCurrency) && "GBP".equals(toCurrency)) {
            return 0.78792; 
        }
        else if ("USD".equals(fromCurrency) && "EUR".equals(toCurrency)) {
            return 0.92351; 
        }
        else if ("USD".equals(fromCurrency) && "BRL".equals(toCurrency)) {
            return 4.9373; 
        }
        else if ("USD".equals(fromCurrency) && "JPY".equals(toCurrency)) {
            return 146.61; 
        }
        else if ("USD".equals(fromCurrency) && "TRY".equals(toCurrency)) {
            return 30.3592; 
        }
        else if ("EUR".equals(fromCurrency) && "GBP".equals(toCurrency)) {
            return 0.85312; 
        }
        else if ("EUR".equals(fromCurrency) && "USD".equals(toCurrency)) {
            return 1.08267; 
        }
        else if ("EUR".equals(fromCurrency) && "BRL".equals(toCurrency)) {
            return 5.34548; 
        }
        else if ("EUR".equals(fromCurrency) && "JPY".equals(toCurrency)) {
            return 158.74; 
        }
        else if ("EUR".equals(fromCurrency) && "TRY".equals(toCurrency)) {
            return 32.8691; 
        }
        else if ("BRL".equals(fromCurrency) && "GBP".equals(toCurrency)) {
            return 0.15947; 
        }
        else if ("BRL".equals(fromCurrency) && "USD".equals(toCurrency)) {
            return 0.20239; 
        }
        else if ("BRL".equals(fromCurrency) && "EUR".equals(toCurrency)) {
            return 0.18691; 
        }
        else if ("BRL".equals(fromCurrency) && "JPY".equals(toCurrency)) {
            return 29.6725; 
        }
        else if ("BRL".equals(fromCurrency) && "TRY".equals(toCurrency)) {
            return 6.14441; 
        }
        else if ("JPY".equals(fromCurrency) && "GBP".equals(toCurrency)) {
            return 0.00537; 
        }
        else if ("JPY".equals(fromCurrency) && "USD".equals(toCurrency)) {
            return 0.00682; 
        }
        else if ("JPY".equals(fromCurrency) && "EUR".equals(toCurrency)) {
            return 0.0063; 
        }
        else if ("JPY".equals(fromCurrency) && "BRL".equals(toCurrency)) {
            return 0.03367; 
        }
        else if ("JPY".equals(fromCurrency) && "TRY".equals(toCurrency)) {
            return 0.20705; 
        }
        else if ("TRY".equals(fromCurrency) && "GBP".equals(toCurrency)) {
            return 0.02595; 
        }
        else if ("TRY".equals(fromCurrency) && "USD".equals(toCurrency)) {
            return 0.03293; 
        }
        else if ("TRY".equals(fromCurrency) && "EUR".equals(toCurrency)) {
            return 0.03041; 
        }
        else if ("TRY".equals(fromCurrency) && "BRL".equals(toCurrency)) {
            return 0.16258; 
        }
        else if ("TRY".equals(fromCurrency) && "JPY".equals(toCurrency)) {
            return 4.8277; 
        }
        else if ("TRY".equals(fromCurrency) && "TRY".equals(toCurrency)) {
            return 1; 
        }
        else if ("JPY".equals(fromCurrency) && "JPY".equals(toCurrency)) {
            return 1; 
        }
        else if ("BRL".equals(fromCurrency) && "BRL".equals(toCurrency)) {
            return 1; 
        }
        else if ("EUR".equals(fromCurrency) && "EUR".equals(toCurrency)) {
            return 1; 
        }
        else if ("USD".equals(fromCurrency) && "USD".equals(toCurrency)) {
            return 1; 
        }
        else if ("GBP".equals(fromCurrency) && "GBP".equals(toCurrency)) {
            return 1; 
        }
        return -1; 
    }
    
    @PostMapping("/saveconversion")
    public String saveConversion(HttpServletRequest request, Model model) {
        try {
        	// Retrieve user details from the session
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String userEmail = userDetails.getUsername();

            // Retrieve data from the original conversion
            double amount = Double.parseDouble(request.getParameter("amount"));
            String fromCurrency = request.getParameter("fromCurrency");
            String toCurrency = request.getParameter("toCurrency");

            double saveAmount = amount;
            
            // Retrieve the conversion rate from the service
            double conversionRate = getConversionRate(fromCurrency, toCurrency);

            // Calculate the final converted amount
            double finalConvertedAmount = amount * conversionRate;

            // Determine the fee based on the provided conditions
            double fee = calculateFee(finalConvertedAmount);

            // Calculate the final amount (final converted amount + fee)
            double finalAmount = finalConvertedAmount + fee;

            // Save the conversion to the database
            boolean saveSuccess = conversionService.saveConversion(saveAmount, finalConvertedAmount, toCurrency, fromCurrency, fee, finalAmount, userEmail);

            // Set save success attribute in the model
            model.addAttribute("saveSuccess", saveSuccess);

            return "currencyconversionpage";
        } catch (NumberFormatException e) {
            // Handle invalid input (non-numeric amount)
            model.addAttribute("conversionSuccess", false);
            return "currencyconversionpage";
        }
    }

    private double getFinalConvertedAmount(double convertedAmount) {
        return convertedAmount;
    }
    
    private double calculateFee(double finalConvertedAmount) {
    	if (finalConvertedAmount <= 500) {
            return finalConvertedAmount * 0.035; // 3.5%
        } else if (finalConvertedAmount <= 1500) {
            return finalConvertedAmount * 0.027; // 2.7%
        } else if (finalConvertedAmount <= 2500) {
            return finalConvertedAmount * 0.02; // 2.0%
        } else {
            return finalConvertedAmount * 0.015; // 1.5%
        }
    }

    private static class ConversionDetails {
        private final boolean conversionSuccess;
        private final double convertedAmount;
        private final double finalConvertedAmount;

        public ConversionDetails(boolean conversionSuccess, double convertedAmount, double finalConvertedAmount) {
            this.conversionSuccess = conversionSuccess;
            this.convertedAmount = convertedAmount;
            this.finalConvertedAmount = finalConvertedAmount;
        }

        public boolean isConversionSuccess() {
            return conversionSuccess;
        }

        public double getConvertedAmount() {
            return convertedAmount;
        }

        public double getFinalConvertedAmount() {
            return finalConvertedAmount;
        }
    }
}
