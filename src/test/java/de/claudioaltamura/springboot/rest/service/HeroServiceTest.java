package de.claudioaltamura.springboot.rest.service;

import de.claudioaltamura.springboot.rest.exception.HeroNotFoundException;
import de.claudioaltamura.springboot.rest.model.HeroRequest;
import de.claudioaltamura.springboot.rest.model.HeroResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroServiceTest {

    private HeroService heroService;
    private long existingId;

    @BeforeEach
    public void setUp() {
        heroService = new HeroServiceImpl();
        HeroResponse heroResponse = heroService.add(new HeroRequest("Batman", 90.0D, "Bruce Wayne", "Gotham City"));
        existingId = heroResponse.getId();
    }

    @Test
    public void whenExistingHeroIdExpectDeleteSuccessfully() {
        heroService.destroy(existingId);

        assertThrows(HeroNotFoundException.class, ()->heroService.findById(existingId));
    }

    @Test
    public void whenNonExistingHeroIdExpectExcpetion() {
        long nonExistingId = 999;
        assertThrows(HeroNotFoundException.class, ()->heroService.findById(nonExistingId));
    }


}