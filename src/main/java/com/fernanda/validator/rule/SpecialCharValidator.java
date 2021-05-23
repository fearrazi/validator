package com.fernanda.validator.rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpecialCharValidator extends PasswordValidator {

	private static final Logger LOG = LoggerFactory.getLogger(SpecialCharValidator.class);
	
	@Override
	public boolean check(String password) {
		List<Character> charList = new ArrayList<Character>(Arrays. asList('!','@','#','$','%','^','&','*','(',')','-','+'));
		
		for (char c : password.toCharArray()) {
			if(charList.contains(c))
				return checkNext(password);
		}
		LOG.info("SpecialCharValidator - should have at least 1 special character");
		return false;
	}
}
