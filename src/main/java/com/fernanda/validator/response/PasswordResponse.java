package com.fernanda.validator.response;

public class PasswordResponse {

	private boolean valid;
	
	public PasswordResponse(boolean valid) {
		this.valid = valid;
	}

	public boolean isValid() {
		return valid;
	}
}
