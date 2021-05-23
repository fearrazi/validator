package com.fernanda.validator.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SequenceValidatorTest {

	private SequenceValidator validator;
	
	@BeforeEach
	void setUp() throws Exception {
		validator = new SequenceValidator();
	}

	@Test
	void shouldNotHaveLetterAndDigitSequences() {
		assertFalse(validator.check("AB"));
		assertFalse(validator.check("ab"));
		assertFalse(validator.check("89"));
		assertTrue(validator.check("Ab"));
		assertTrue(validator.check("ZA"));
		assertTrue(validator.check("za"));
		assertTrue(validator.check("90"));
	}

}
