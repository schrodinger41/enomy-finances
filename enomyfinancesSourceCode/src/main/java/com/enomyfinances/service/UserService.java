package com.enomyfinances.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public interface UserService {

	void registerNewClient(String firstName, String lastName, String email, String password, int phoneNumber);

	boolean emailExists(String email);
	
	void setPasswordEncoder(PasswordEncoder passwordEncoder);
	
	
	}

