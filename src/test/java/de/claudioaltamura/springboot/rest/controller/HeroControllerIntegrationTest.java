package de.claudioaltamura.springboot.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.claudioaltamura.springboot.rest.model.HeroRequest;
import de.claudioaltamura.springboot.rest.service.HeroService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HeroController.class)
class HeroControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private HeroService heroService;

  @Test
  void shouldReturnNoContent() throws Exception {
    HeroRequest heroRequest = new HeroRequest("Batman",
        90.0d, "Bruce Wayne", "Gotham City");

    mockMvc.perform(post("/api/v1/heroes/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(heroRequest)))
        .andExpect(status().isNoContent())
        .andReturn();

    ArgumentCaptor<HeroRequest> heroRequestCaptor = ArgumentCaptor.forClass(HeroRequest.class);

    verify(heroService, atLeastOnce()).add(heroRequestCaptor.capture());
    assertThat(heroRequestCaptor.getValue().getName()).isEqualTo("Batman");
  }

  @Test
  void shouldThrownAnValidationError() throws Exception {
    String invalidHeroRequest = "{\"name\":\"Batman\",\"power\":100.1,\"realName\":\"Bruce Wayne\",\"city\":\"Gotham City\"}";

    MvcResult mvcResult = mockMvc.perform(post("/api/v1/heroes/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(invalidHeroRequest))
            .andExpect(status().isBadRequest())
            .andReturn();


  }

}