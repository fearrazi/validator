package com.fernanda.validator.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernanda.validator.request.PasswordRequest;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PasswordControllerTest {
	
	private final String URL = "/validator";
	private ObjectMapper objectMapper;
	private MockMvc mockMvc;
	
	@Autowired
    private PasswordController passwordController;
	
	@BeforeEach
	void setUp() throws Exception { objectMapper = new ObjectMapper();
    mockMvc = MockMvcBuilders
            .standaloneSetup(passwordController)
            .build();
	}

	@Test
	void shouldBeValid() throws Exception {
		PasswordRequest request = new PasswordRequest();
		request.setPassword("AbTp9!fok");

		mockMvc.perform(post(URL)
				.content(objectMapper.writeValueAsString(request))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.valid").value(true));
	}

	@Test
	void shouldNotBeValid() throws Exception {
		PasswordRequest request = new PasswordRequest();
		request.setPassword("AbTp9!fokk");

		mockMvc.perform(post(URL)
				.content(objectMapper.writeValueAsString(request))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.valid").value(false));
	}
	
	@Test
	void shouldNotBeBlank() throws Exception {
		PasswordRequest request = new PasswordRequest();
		request.setPassword("");

		mockMvc.perform(post(URL)
				.content(objectMapper.writeValueAsString(request))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.valid").value(false));
	}
	
	@Test
	void shouldReturnBadRequest() throws Exception {
		PasswordRequest request = new PasswordRequest();
		request.setPassword(null);

		mockMvc.perform(post(URL)
				.content(objectMapper.writeValueAsString(request))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());
	}
}
