package de.claudioaltamura.springboot.rest;

import static org.assertj.core.api.Assertions.assertThat;

import de.claudioaltamura.springboot.rest.web.HeroController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HeroApplicationTests {

	@Autowired
	private HeroController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
