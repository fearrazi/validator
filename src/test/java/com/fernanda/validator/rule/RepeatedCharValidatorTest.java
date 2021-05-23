package com.fernanda.validator.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RepeatedCharValidatorTest {

	private RepeatedCharValidator validator;
	
	@BeforeEach
	void setUp() throws Exception {
		validator = new RepeatedCharValidator();
	}

	@Test
	void shouldNotHaveRepeatedCharacters() {
		assertFalse(validator.check("AA"));
		assertFalse(validator.check("aa"));
		assertFalse(validator.check("99"));
		assertFalse(validator.check("&&"));
		assertTrue(validator.check("Aa"));
	}

}
