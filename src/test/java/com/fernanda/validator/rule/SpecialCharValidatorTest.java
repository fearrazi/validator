package com.fernanda.validator.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpecialCharValidatorTest {

	private SpecialCharValidator validator;
	
	@BeforeEach
	void setUp() throws Exception {
		validator = new SpecialCharValidator();
	}

	@Test
	void shouldHaveAtLeastOneSpecialCharacter() {
		assertFalse(validator.check("aaaa"));
		assertTrue(validator.check("aaaa!"));
		assertTrue(validator.check("aaaa@"));
		assertTrue(validator.check("aaaa#"));
		assertTrue(validator.check("aaaa$"));
		assertTrue(validator.check("aaaa%"));
		assertTrue(validator.check("aaaa^"));
		assertTrue(validator.check("aaaa&"));
		assertTrue(validator.check("aaaa*"));
		assertTrue(validator.check("aaaa("));
		assertTrue(validator.check("aaaa)"));
		assertTrue(validator.check("aaaa-"));
		assertTrue(validator.check("aaaa+"));
	}

}
