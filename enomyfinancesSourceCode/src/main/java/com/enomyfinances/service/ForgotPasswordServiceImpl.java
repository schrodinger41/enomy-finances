package com.enomyfinances.service;
import com.enomyfinances.models.User;
import com.enomyfinances.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public String changePassword(String email, String password, String passwordConfirmation) {
        // Check if passwords match
        if (!password.equals(passwordConfirmation)) {
            return "Passwords do not match";
        }
        
     // Encode the password
        String encodedPassword = passwordEncoder.encode(password);
        
        // Validate email and reset password logic
        try {
            User user = userRepository.findByEmail(email);

            if (user != null) {
                // Email found, update password
                user.setPassword(encodedPassword);
                userRepository.save(user);
                return "Password changed successfully";
            } else {
                // Email not found, set error message
                return "Email does not exist";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error"; // Handle errors appropriately
        }
    }
}
