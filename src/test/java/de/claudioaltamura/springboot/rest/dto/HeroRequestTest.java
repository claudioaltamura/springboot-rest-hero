package de.claudioaltamura.springboot.rest.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonTest
class HeroRequestTest {

    //ToString
    //Bean Validation

	@Autowired
	private JacksonTester<HeroRequest> json;

	@Test
	 void serialize() throws IOException {
		HeroRequest heroRequest = new HeroRequest("Batman", 100.0d, "Bruce Wayne", "Gotham City");

		JsonContent<HeroRequest> result = this.json.write(heroRequest);

		assertThat(result).hasJsonPathStringValue("$.name");
		assertThat(result).extractingJsonPathStringValue("$.name").isEqualTo("Batman");
	}

	@Test
	void deserialize() throws IOException {

			String jsonContent = "{\"name\":\"Batman\", \"power\": 100.0, \"realName\":\"Bruce Wayne\"," +
					" \"city\": \"Gotham City\"}";

			HeroRequest result = this.json.parse(jsonContent).getObject();

			assertThat(result.getName()).isEqualTo("Batman");
			assertThat(result.getPower()).isEqualTo(100.0d);
	}

}