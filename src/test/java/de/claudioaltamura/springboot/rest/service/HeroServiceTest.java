package de.claudioaltamura.springboot.rest.service;

import de.claudioaltamura.springboot.rest.dto.HeroRequest;
import de.claudioaltamura.springboot.rest.dto.HeroRequestWithId;
import de.claudioaltamura.springboot.rest.dto.HeroResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroServiceTest {

    private HeroService heroService;
    private long existingId;

    @BeforeEach
	void setUp() {
        heroService = new HeroServiceImpl();
        HeroResponse heroResponse = heroService.add(new HeroRequest("Batman", 90.0D, "Bruce Wayne", "Gotham City"));
        existingId = heroResponse.getId();
    }

    @Test
	void whenExistingHeroIdExpectDeleteSuccessfully() {
        heroService.destroy(existingId);

        assertThrows(HeroNotFoundException.class, ()->heroService.findById(existingId));
    }

    @Test
	void whenNonExistingHeroIdExpectExcpetion() {
        long nonExistingId = 999;
        assertThrows(HeroNotFoundException.class, ()->heroService.findById(nonExistingId));
    }

    @Test
	void whenExistingHerodIdExceptHero() {
    	assertNotNull(heroService.findById(existingId));
	}

	@Test
	void whenAddHeroExceptSuccess() {
		HeroResponse savedHero = heroService.add(new HeroRequest("Robin", 80.0D, "Jason Peter Todd", "Gotham City"));;

		assertNotNull(heroService.findById(savedHero.getId()));
	}

	@Test
	void whenUpdateHeroExceptSuccess() {
		HeroResponse savedHero = heroService.add(new HeroRequest("Robin", 80.0D, "Jason Peter Todd", "Gotham City"));;

    	heroService.update(new HeroRequestWithId(savedHero.getId(), savedHero.getName(), 85.0D, savedHero.getRealName(), savedHero.getCity()));


    	HeroResponse updatedHero = heroService.findById(savedHero.getId());

    	assertEquals(85.0D, updatedHero.getPower());
	}

}