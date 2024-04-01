package com.enomyfinances.repository;

import com.enomyfinances.models.UserInvestment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInvestmentRepository extends JpaRepository<UserInvestment, Long> {
	List<UserInvestment> findByUserId(long userId);
}
