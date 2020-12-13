package de.claudioaltamura.springboot.rest.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroTest {

    @Test
    void equals() {
        Hero hero1a = new Hero(1);
        Hero hero1b = new Hero(1);

        assertEquals(hero1a, hero1b);
    }

    @Test
    void testToString() {
        assertEquals("Hero(id=1)", new Hero(1).toString());
    }

    @Test
    void requiredArgsConstructor() {
        Hero hero = new Hero(1);
        assertEquals(1, hero.getId());
    }

    @Test
    void allArgsConstructor() {
        Hero hero = new Hero(1, "Batmann", 99.0d, "Bruce Wayne", "Metropolis");
        assertEquals("Metropolis", hero.getCity());
    }

    @Test
    void set() {
        Hero hero = new Hero(1);
        //hero.setId(); not available
    }
}
