package com.advicenerds.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advicenerds.testing.model.User;

/**
 * 
 * @author Marcus Lowe
 *
 */
public interface UserRepository extends JpaRepository<User,Long> {

	
}
