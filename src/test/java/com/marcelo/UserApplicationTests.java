package com.marcelo;

import com.marcelo.entity.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserApplicationTests {


	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateUser() {
		var user = new Usuario("Marcelo","marcelo@gmail.com","123456");
		webTestClient.post().uri("/user")
				.bodyValue(user)
				.exchange()
				.expectStatus().isCreated()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].nome").isEqualTo(user.getNome())
				.jsonPath("$[0].email").isEqualTo(user.getEmail())
				.jsonPath("$[0].senha").isEqualTo(user.getSenha());

	}

}
