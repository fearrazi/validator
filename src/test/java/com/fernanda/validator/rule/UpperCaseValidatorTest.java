package com.fernanda.validator.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UpperCaseValidatorTest {

	private UpperCaseValidator validator;
	
	@BeforeEach
	void setUp() throws Exception {
		validator = new UpperCaseValidator();
	}

	@Test
	void shouldHaveAtLeastOneUpperCaseLetter() {
		assertFalse(validator.check("aaa"));
		assertTrue(validator.check("aaaA"));
	}

}
