package de.claudioaltamura.springboot.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.claudioaltamura.springboot.rest.model.HeroRequest;
import de.claudioaltamura.springboot.rest.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HeroApplication implements ApplicationRunner {

	@Autowired
	private HeroService heroService;

	public static void main(String[] args) {
		SpringApplication.run(HeroApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		heroService.add(new HeroRequest("Batman",
		 90.0d, "Bruce Wayne", "Gotham City"));
	}
}
