package com.fernanda.validator.request;

import javax.validation.constraints.NotNull;

public class PasswordRequest {
	
	@NotNull(message = "A senha não pode ser nula") 
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
