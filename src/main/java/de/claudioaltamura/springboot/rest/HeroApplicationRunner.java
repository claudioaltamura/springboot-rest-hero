package de.claudioaltamura.springboot.rest;

import de.claudioaltamura.springboot.rest.dto.HeroRequest;
import de.claudioaltamura.springboot.rest.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class HeroApplicationRunner implements ApplicationRunner {

	@Autowired
	private HeroService heroService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		heroService.add(new HeroRequest("Batman",
				90.0d, "Bruce Wayne", "Gotham City"));
	}
}
