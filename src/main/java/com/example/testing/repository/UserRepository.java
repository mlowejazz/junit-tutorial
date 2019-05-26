package com.example.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testing.model.User;

/**
 * 
 * @author Marcus Lowe
 *
 */
public interface UserRepository extends JpaRepository<User,Long> {

	
}
