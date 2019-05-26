package com.example.testing.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.testing.model.User;
import com.example.testing.repository.UserRepository;

/**
 * 
 * @author Marcus Lowe
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserServiceImpl(final UserRepository userRepository, final UserService userService,
			final PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User addNewUser(final String emailAddress, final String password) {
		User user = new User();
		user.setEmailAddress(emailAddress);
		user.setPassword(passwordEncoder.encode(password));
		return userRepository.save(user);

	}

	@Override
	public User getById(Long id) {
		return userRepository.getOne(id);
	}

}
