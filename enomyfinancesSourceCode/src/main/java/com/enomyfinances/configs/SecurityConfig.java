package com.enomyfinances.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Import BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder;

import com.enomyfinances.auth.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Bean
   public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	super.configure(auth);
    	System.out.println("Configure Authentication");
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }
  
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("Configure HttpSecurity");
        http
	        .formLogin()
	            .loginPage("/login")
	            .defaultSuccessUrl("/welcome")
	            .permitAll()
	            .and()
	        .authorizeRequests() 
	            .antMatchers(HttpMethod.POST, "/enomyfinancesSourceCode/registerprocess").permitAll()
	            .antMatchers(HttpMethod.POST, "/forgotpassword").permitAll()
	            .antMatchers("/").permitAll()
	            .antMatchers("/login", "/register",  "/forgotpassword", "/login?error").permitAll()
	            .antMatchers("/thankyou").permitAll()
	            .antMatchers("/welcome").hasAnyRole("User", "Admin")
	            .antMatchers("/currencyconversionpage", "/investmentspage").hasAnyRole("Admin", "User")
	            .antMatchers(HttpMethod.POST, "/currencyconversion").hasAnyRole("Admin", "User")
	            .antMatchers(HttpMethod.POST, "/saveconversion").hasAnyRole("Admin", "User")
	            .antMatchers(HttpMethod.POST, "/saveinvestment").hasAnyRole("Admin", "User")
	            .and()
	        .logout()
	            .logoutUrl("/logout") 
	            .invalidateHttpSession(true)
	            .logoutSuccessUrl("/login")
	            .deleteCookies("SESSIONID")
	            .permitAll();
   }
}
