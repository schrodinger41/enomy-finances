package com.enomyfinances.service;

import java.util.List;

import com.enomyfinances.models.CurrencyConversion;

public interface CurrencyConversionService {
    boolean saveConversion( double saveAmount2,double finalConvertedAmount, String toCurrency, String fromCurrency, double fee, double finalAmount, String userEmail);

	List<CurrencyConversion> findAllSavedConversions(String email);
}