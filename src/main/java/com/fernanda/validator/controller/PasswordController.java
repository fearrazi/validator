package com.fernanda.validator.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fernanda.validator.request.PasswordRequest;
import com.fernanda.validator.response.PasswordResponse;
import com.fernanda.validator.service.PasswordService;

@RestController
@RequestMapping("/validator")
public class PasswordController {
	
	private PasswordService passwordService;
	
	@Autowired
	public PasswordController(PasswordService passwordService) {
		this.passwordService = passwordService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PasswordResponse> isValid(@RequestBody @Valid PasswordRequest passwordRequest) {
		Boolean isValidPassword = passwordService.isValidPassword(passwordRequest.getPassword());
		return ResponseEntity.ok(new PasswordResponse(isValidPassword));
	}
}
