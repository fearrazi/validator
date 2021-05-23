package com.fernanda.validator.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WhiteSpaceValidatorTest {

	private WhiteSpaceValidator validator;
	
	@BeforeEach
	void setUp() throws Exception {
		validator = new WhiteSpaceValidator();
	}

	@Test
	void shouldNotHaveWhiteSpace() {
		assertFalse(validator.check("AbTp9!fo k"));
	}

}
