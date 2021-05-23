package com.fernanda.validator.rule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpperCaseValidator extends PasswordValidator {

	private static final Logger LOG = LoggerFactory.getLogger(UpperCaseValidator.class);
	
	@Override
	public boolean check(String password) {
		for (char c : password.toCharArray()) {
			if(Character.isUpperCase(c))
				return checkNext(password);
		}
		LOG.info("UpperCaseValidator - should have at least 1 upper case letter");
		return false;
	}
}
