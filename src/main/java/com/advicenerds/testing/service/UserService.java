package com.advicenerds.testing.service;

import com.advicenerds.testing.model.User;

/**
 * 
 * @author Marcus Lowe
 *
 */
public interface UserService {

	User addNewUser(final String emailAddress, final String password);
	User getById(Long id);
}
