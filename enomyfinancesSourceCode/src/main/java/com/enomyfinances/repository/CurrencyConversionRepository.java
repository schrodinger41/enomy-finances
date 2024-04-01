package com.enomyfinances.repository;
import java.util.List;

//CurrencyConversionRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

import com.enomyfinances.models.CurrencyConversion;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, Long> {
	List<CurrencyConversion> findByUserEmail(String email);

}

