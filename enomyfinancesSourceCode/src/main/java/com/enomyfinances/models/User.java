package com.enomyfinances.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.persistence.*;

@Entity
@Table(name = "userDetails")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private long userId;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phoneNumber")
	private int phoneNumber;
	
	@Column(name = "password")
	private String password;
	
	@ManyToMany
	@JoinTable( name = "userRole",
				joinColumns = @JoinColumn(name = "userId"),
				inverseJoinColumns = @JoinColumn(name = "roleId"))
	private Set<Role> roles = new HashSet<>();
	
	
	
	public User() {}
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public User(String email, String password, Set<Role> roles) {
		super();
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public User(int userId, String firstName, String lastName, String email, int phoneNumber, String password) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	
	public User(int userId, String firstName, String lastName, String email, int phoneNumber, String password,
			Set<Role> roles) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.roles = roles;
	}

	public long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User User = (User) o;
        return email.equals(User.email) && password.equals(User.password);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }

	public String getUserName() {
		// TODO Auto-generated method stub
		return email;
	}
}
