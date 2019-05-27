package com.advicenerds.testing.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.advicenerds.testing.model.User;
import com.advicenerds.testing.repository.UserRepository;
import com.advicenerds.testing.service.UserServiceImpl;

/**
 * 
 * @author Marcus Lowe
 *
 */
public class UserServiceImplTest {

	@Mock
	private UserRepository userRepository;
	
	@Mock
	private PasswordEncoder passwordEncoder;
	
	@Mock
	private User user;
	
	private UserServiceImpl userService;
	private Long id = 1L;
	
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		userService = new UserServiceImpl(userRepository, userService, passwordEncoder);
		when(userRepository.getOne(id)).thenReturn(user);
		when(userRepository.save(ArgumentMatchers.any(User.class))).then(returnsFirstArg());
		
	}
	
	@After
	public void after() {
		userService = null;
	}
	
	
	@Test
	public void testGetUser() {
		assertEquals(user,userService.getById(id));
	}
	
	@Test
	public void testSaveNewUser() {
		String emailAddress = "soulSista";
		String password = "testing123";
		String encryptedPassword = "encryptedValue";
		when(passwordEncoder.encode(password)).thenReturn(encryptedPassword);
		
		User user = userService.addNewUser(emailAddress, password);
		assertEquals(emailAddress,user.getEmailAddress());
		assertEquals(user.getPassword(),encryptedPassword);
	}

}
