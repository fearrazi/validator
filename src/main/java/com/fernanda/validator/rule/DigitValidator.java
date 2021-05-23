package com.fernanda.validator.rule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DigitValidator extends PasswordValidator {

	private static final Logger LOG = LoggerFactory.getLogger(DigitValidator.class);
	
	@Override
	public boolean check(String password) {
		for (char c : password.toCharArray()) {
			if(Character.isDigit(c))
				return checkNext(password);
		}
		LOG.info("DigitValidator - should have at least 1 digit");
		return false;
	}
}
