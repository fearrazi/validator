package com.fernanda.validator.rule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LowerCaseValidator extends PasswordValidator {

	private static final Logger LOG = LoggerFactory.getLogger(LowerCaseValidator.class);
	
	@Override
	public boolean check(String password) {
		for (char c : password.toCharArray()) {
			if(Character.isLowerCase(c))
				return checkNext(password);
		}
		LOG.info("LowerCaseValidator - should have at least 1 lower case letter");
		return false;
	}
}
