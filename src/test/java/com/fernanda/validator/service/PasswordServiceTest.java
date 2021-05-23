package com.fernanda.validator.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordServiceTest {

	private PasswordService passwordService;

	@BeforeEach
	public void setUp() {
		this.passwordService = new PasswordService();
	}
	
	@Test
	void passwordShouldBeValid() {
		assertFalse(passwordService.isValidPassword(""));
		assertFalse(passwordService.isValidPassword(""));
		assertFalse(passwordService.isValidPassword("aa"));  
		assertFalse(passwordService.isValidPassword("ab"));  
		assertFalse(passwordService.isValidPassword("AAAbbbCc")); 
		assertFalse(passwordService.isValidPassword("AbTp9!foo"));
		assertFalse(passwordService.isValidPassword("AbTp9!foA"));
		assertFalse(passwordService.isValidPassword("AbTp9 fok"));
		assertTrue(passwordService.isValidPassword("AbTp9!fok"));
	}
}
