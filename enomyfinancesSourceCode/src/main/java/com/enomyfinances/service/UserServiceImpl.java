package com.enomyfinances.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.enomyfinances.models.Role;
import com.enomyfinances.models.User;
import com.enomyfinances.repository.RoleRepository;
import com.enomyfinances.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    // Method to list all users
    public List<User> listAll() {
        return userRepository.findAll();
    }

    // Method to get a user by ID
    public User get(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new IllegalArgumentException("User not found with ID: " + id);
        }
    }
    
    // Method to delete a user by ID
    public void delete(Long userId) {
        userRepository.deleteByUserId(userId);
    }

    // Method to register a new client
    @Override
    public void registerNewClient(String firstName, String lastName, String email, String password, int phoneNumber) {
        
        if (emailExists(email)) {
            throw new RuntimeException("Email already exists");
        }

        String encodedPassword = passwordEncoder.encode(password);

        User myUser = new User();
        myUser.setFirstName(firstName);
        myUser.setLastName(lastName);
        myUser.setEmail(email);
        myUser.setPhoneNumber(phoneNumber); // Set the phoneNumber as an int
        myUser.setPassword(encodedPassword); // Store the encoded password

        Role userRole = roleRepository.findByRoleName("User");
        if (userRole == null) {
            throw new RuntimeException("Role 'User' not found. Please make sure it exists in the database.");
        } else {
            myUser.setRoles(Collections.singleton(userRole));
            // Save user to the database
            userRepository.save(myUser);

            System.out.println("\nNew User Has Been Registered!"
                + "\nName: " + firstName + " " + lastName
                + "\nEmail: " + email
                + "\nPhone Number: " + phoneNumber);
            
        }
        
    }
    
    

    @Override
    public boolean emailExists(String email) {
        User myUser = userRepository.findByEmail(email);
        return myUser != null; 
    }

	@Override
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		// TODO Auto-generated method stub
		
	}
    
    


   
}
