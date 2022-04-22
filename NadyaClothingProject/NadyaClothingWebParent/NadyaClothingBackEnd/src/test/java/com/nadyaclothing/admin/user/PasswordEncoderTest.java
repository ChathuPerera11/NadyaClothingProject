package com.nadyaclothing.admin.user;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
	@Test
	public void testEncodePassword() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPassword = "admin123";
		String encodedPassword = passwordEncoder.encode(rawPassword);
		
		System.out.println("pw: " + encodedPassword);
		//$2a$10$4hVHwMsCOWku39aGdJVRCO0bUaorEb4yW2iT6rMnsr/jMVUbYEvdW
		boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);
		
		assertThat(matches).isTrue();
	}
}
