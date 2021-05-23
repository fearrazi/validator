package com.fernanda.validator.rule;

public abstract class PasswordValidator {

	private PasswordValidator nextValidator;

	public PasswordValidator setNext(PasswordValidator nextValidator) {
        this.nextValidator = nextValidator;
        return nextValidator;
    }
	
	public abstract boolean check(String password);

	protected boolean checkNext(String password) {
		if (this.nextValidator == null) {
			return true;
		}
		return this.nextValidator.check(password);
	}
}
