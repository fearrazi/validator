package com.fernanda.validator.rule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WhiteSpaceValidator extends PasswordValidator {

	private static final Logger LOG = LoggerFactory.getLogger(WhiteSpaceValidator.class);
	
	@Override
	public boolean check(String password) {
		for (char c : password.toCharArray()) {
			if(Character.isWhitespace(c)) {
				LOG.info("WhiteSpaceValidator - should not have white space");
				return false;
			}
		}
		return checkNext(password);
	}
}
