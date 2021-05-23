package com.fernanda.validator.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LengthValidatorTest {

	private LengthValidator validator;
	
	@BeforeEach
	void setUp() throws Exception {
		validator = new LengthValidator();
	}

	@Test
	void shouldHaveAtLeastNineCharacters() {
		assertFalse(validator.check("12345678"));
		assertFalse(validator.check(""));
		assertTrue(validator.check("123456789"));
	}

}
