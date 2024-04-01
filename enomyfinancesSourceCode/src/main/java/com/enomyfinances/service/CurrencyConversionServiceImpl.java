package com.enomyfinances.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enomyfinances.models.CurrencyConversion;
import com.enomyfinances.models.User;
import com.enomyfinances.repository.CurrencyConversionRepository;
import com.enomyfinances.repository.UserRepository;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    @Autowired
    private CurrencyConversionRepository conversionRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    public CurrencyConversionServiceImpl(CurrencyConversionRepository conversionRepository) {
        this.conversionRepository = conversionRepository;
    }
    
    public List<CurrencyConversion> findAllSavedConversions(String email) {
        return conversionRepository.findByUserEmail(email);
    }

    @Override
    public boolean saveConversion(double saveAmount, double finalConvertedAmount, String toCurrency, String fromCurrency, double fee, double finalAmount, String userEmail) {
        try {
            // Find the user by email
            User user = userRepository.findByEmail(userEmail);

            if (user != null) {
                // Create a CurrencyConversion entity with the user
                CurrencyConversion conversion = new CurrencyConversion();
                conversion.setUser(user);
                conversion.setAmount(saveAmount);
                conversion.setConvertedAmount(finalConvertedAmount);
                conversion.setToCurrency(toCurrency);
                conversion.setFromCurrency(fromCurrency);
                conversion.setFinalAmount(finalAmount);
                conversion.setFee(fee);
                System.out.println("Currency Conversion saved");
                // Save the conversion to the database
                conversionRepository.save(conversion);

                return true; // Return true if the save is successful
            } else {
                // Handle the case where the user is not found for the given email
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false if there is an error
        }
    }
}
