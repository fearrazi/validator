package com.fernanda.validator.service;

import org.springframework.stereotype.Service;

import com.fernanda.validator.rule.DigitValidator;
import com.fernanda.validator.rule.LengthValidator;
import com.fernanda.validator.rule.LowerCaseValidator;
import com.fernanda.validator.rule.PasswordValidator;
import com.fernanda.validator.rule.RepeatedCharValidator;
import com.fernanda.validator.rule.SequenceValidator;
import com.fernanda.validator.rule.SpecialCharValidator;
import com.fernanda.validator.rule.UpperCaseValidator;
import com.fernanda.validator.rule.WhiteSpaceValidator;

@Service
public class PasswordService {

	public boolean isValidPassword(String password) {
		PasswordValidator validator = new LengthValidator();
		validator.setNext(new WhiteSpaceValidator())
				.setNext(new DigitValidator())
				.setNext(new LowerCaseValidator())
				.setNext(new UpperCaseValidator())
				.setNext(new SpecialCharValidator())
				.setNext(new RepeatedCharValidator())
				.setNext(new SequenceValidator());
		
		return validator.check(password);
	}
}
