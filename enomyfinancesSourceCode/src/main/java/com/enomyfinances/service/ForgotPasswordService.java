package com.enomyfinances.service;

public interface ForgotPasswordService {
    String changePassword(String email, String password, String passwordConfirmation);
}
