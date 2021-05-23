package com.fernanda.validator.rule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LengthValidator extends PasswordValidator {

	private static final Logger LOG = LoggerFactory.getLogger(LengthValidator.class);
	
	@Override
	public boolean check(String password) {
		if(password.length() >= 9) 
			return checkNext(password);
			
		LOG.info("LenghtValidator - should have at least 9 characters");
		return false;
	}
}
