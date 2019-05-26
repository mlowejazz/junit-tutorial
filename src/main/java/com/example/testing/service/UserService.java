package com.example.testing.service;

import com.example.testing.model.User;

/**
 * 
 * @author Marcus Lowe
 *
 */
public interface UserService {

	User addNewUser(final String emailAddress, final String password);
	User getById(Long id);
}
