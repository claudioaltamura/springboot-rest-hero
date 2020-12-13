package de.claudioaltamura.springboot.rest;

import static org.assertj.core.api.Assertions.assertThat;

import de.claudioaltamura.springboot.rest.dto.HeroResponse;
import de.claudioaltamura.springboot.rest.web.HeroController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

/**
 * API Test. Starts everything.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HeroApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private HeroController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	void shouldReturnSomething() {
		HeroResponse[] heroes = restTemplate.getForObject("http://localhost:" + port + "/api/v1/heroes",
				HeroResponse[].class);
		assertThat(heroes).isNotNull();
	}
}
