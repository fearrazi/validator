package com.fernanda.validator.rule;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SequenceValidator extends PasswordValidator {

	private static final Logger LOG = LoggerFactory.getLogger(SequenceValidator.class);
	
	@Override
	public boolean check(String password) {
		List<String> sequenceList = new ArrayList<>();
		sequenceList.add("abcdefghijklmnopqrstuvyxwz");
		sequenceList.add("ABCDEFGHIJKLMNOPQRSTUVYXWZ");
		sequenceList.add("0123456789");
		
		for(String sequence: sequenceList) {
			for (int i = 0; i < sequence.toCharArray().length-1; i++) {
				if(password.contains(sequence.subSequence(i, i+2))) {
					LOG.info("SequenceValidator - should not have sequences");
					return false;
				}
			}
		}
		return checkNext(password);
	}
}
