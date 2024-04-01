package com.enomyfinances.repository;

import com.enomyfinances.models.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.userId = :userId")
    Optional<User> findByUserId(@Param("userId") Long userId);
	
	User findByEmail(String email);

	void deleteByUserId(Long userId);
	
	User findByEmailAndPassword(String email, String password);
	}
