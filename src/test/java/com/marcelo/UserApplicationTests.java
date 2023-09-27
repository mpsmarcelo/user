package com.marcelo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcelo.entity.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserApplicationTests {


	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateUser() {
		var user = new Usuario("Marcelo","marcelo@gmail.com","123456");
		Objects.requireNonNull(webTestClient.post().uri("/user")
				.bodyValue(user)
				.exchange()
				.expectStatus().isCreated()
				.expectBody(Usuario.class)
				.returnResult().getResponseBody()).getEmail().equals(user.getEmail());

	}

}
