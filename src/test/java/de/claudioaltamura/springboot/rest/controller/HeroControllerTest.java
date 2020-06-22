package de.claudioaltamura.springboot.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.claudioaltamura.springboot.rest.model.HeroRequest;
import de.claudioaltamura.springboot.rest.service.HeroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HeroController.class)
class HeroControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private HeroService heroService;

  @Test
  public void shouldReturnNoContent() throws Exception {
    HeroRequest heroRequest = new HeroRequest("Batman",
        90.0d, "Bruce Wayne", "Gotham City");

    this.mockMvc.perform(post("/api/v1/heroes/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(heroRequest)))
        .andExpect(status().isNoContent());
  }
}