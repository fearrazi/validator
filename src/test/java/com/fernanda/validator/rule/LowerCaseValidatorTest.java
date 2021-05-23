package com.fernanda.validator.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LowerCaseValidatorTest {

	private LowerCaseValidator validator;
	
	@BeforeEach
	void setUp() throws Exception {
		validator = new LowerCaseValidator();
	}

	@Test
	void shouldHaveAtLeastOneLowerCaseLetter() {
		assertFalse(validator.check("AAA"));
		assertTrue(validator.check("AAa"));
	}

}
