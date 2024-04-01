package com.enomyfinances.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.enomyfinances.models.Role;
import com.enomyfinances.models.User;
import com.enomyfinances.repository.UserRepository;


@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	 try {
             User user = userRepository.findByEmail(email);

             if (user == null) {
                 throw new UsernameNotFoundException("User " + email + " is invalid, please enter again");
             }

             UserBuilder userBuilder = org.springframework.security.core.userdetails.User.builder();

             String[] roleNames = user.getRoles().stream().map(Role::getName).toArray(String[]::new);

             System.out.println("Role Name from UserDetailServiceImpl is " + roleNames);
             System.out.println("Password: " + user.getPassword());
             return userBuilder.username(user.getUserName())
                     .password(user.getPassword())
                     .roles(roleNames)
                     .build();
         } catch (BadCredentialsException e) {
             System.out.println("Login failed");
           
             throw new BadCredentialsException("Login failed. Please check your email and password.");
         }
     }
 }