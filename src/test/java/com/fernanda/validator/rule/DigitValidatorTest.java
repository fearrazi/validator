package com.fernanda.validator.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DigitValidatorTest {

	private DigitValidator validator;

	@BeforeEach
	void setUp() {
		validator = new DigitValidator();
	}

	@Test
	void shouldHaveAtLeastOneDigit() {
		assertFalse(validator.check("aaaa"));
		assertTrue(validator.check("aaa5a"));
	}
}
