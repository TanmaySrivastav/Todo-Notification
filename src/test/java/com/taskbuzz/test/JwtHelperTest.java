package com.taskbuzz.test;

  
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.taskbuzz.entities.Role;
import com.taskbuzz.security.JwtHelper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class JwtHelperTest {

	// Replace with your actual secret key
	private static final String SECRET_KEY = "afafasfafafasfasfasfafacasdasfasxASFACASDFACASDFASFASFDAFASFASDAADSCSDFADCVSGCFVADXCcadwavfsfarvf";

	@Test
	public void testGenerateAndValidateToken() {
		// Create a user details object for testing
		UserDetails userDetails = new User("testUser", "testPassword", List.of(new SimpleGrantedAuthority(Role.USER.name())));

		// Create a JWT helper instance
		JwtHelper jwtHelper = JwtHelper.getInstance();

		// Generate a token
		String token = jwtHelper.generateToken(userDetails);

		// Validate the token
		assertTrue(jwtHelper.validateToken(token, userDetails));
	}

	@Test
	public void testGetUsernameFromToken() {
		// Create a user details object for testing
		UserDetails userDetails = new User("testUser", "testPassword", List.of(new SimpleGrantedAuthority(Role.USER.name())));

		// Create a JWT helper instance
		JwtHelper jwtHelper = JwtHelper.getInstance();

		// Generate a token
		String token = jwtHelper.generateToken(userDetails);

		// Get username from the token and assert
		assertEquals("testUser", jwtHelper.getUsernameFromToken(token));
	}

	
}


