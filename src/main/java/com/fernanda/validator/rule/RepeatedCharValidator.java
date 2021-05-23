package com.fernanda.validator.rule;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepeatedCharValidator extends PasswordValidator {

	private static final Logger LOG = LoggerFactory.getLogger(RepeatedCharValidator.class);
	
	@Override
	public boolean check(String password) {
		List<Character> charList = new ArrayList<Character>();
		
		for (char c : password.toCharArray()) {
			if(charList.contains(c)) {
				LOG.info("RepeatedCharValidator - should not have repeated characters");
				return false;
			}
			charList.add(c);
		}
		return checkNext(password);
	}
}
