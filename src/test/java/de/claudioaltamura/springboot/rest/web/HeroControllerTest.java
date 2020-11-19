package de.claudioaltamura.springboot.rest.web;

import de.claudioaltamura.springboot.rest.model.HeroRequest;
import de.claudioaltamura.springboot.rest.model.HeroResponse;
import de.claudioaltamura.springboot.rest.service.HeroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * no web server.
 */
@WebMvcTest(HeroController.class)
class HeroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HeroService service;

    @Test
    void whenAddHeroThenReturnIsCreated() throws Exception {
        String heroRequest = "{\"name\":\"Batman\",\"power\":90.0,\"realName\":\"Bruce Wayne\",\"city\":\"Gotham City\"}";

        when(service.add(any(HeroRequest.class))).thenReturn(HeroResponse.of(1, "me", 90.0d, "test", "city"));

        mockMvc.perform(post("/api/v1/heroes/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(heroRequest))
                .andExpect(status().isCreated());
    }

    @Test
    void whenExistingHeroIdExceptDeleteSuccess() throws Exception {
        String heroRequest = "{\"name\":\"Batman\",\"power\":90.0,\"realName\":\"Bruce Wayne\",\"city\":\"Gotham City\"}";

        doNothing().when(service).destroy(anyLong());

        mockMvc.perform(delete("/api/v1/heroes/{heroesId}", 1))
                .andExpect(status().isNoContent());

        verify(service).destroy(anyLong());
    }
}