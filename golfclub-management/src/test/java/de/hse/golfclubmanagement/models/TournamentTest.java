package de.hse.golfclubmanagement.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TournamentTest {

    private Tournament tournament;

    @BeforeEach
    void setUp() {
        tournament = new Tournament();
    }

    @Test
    void testIdField() {
        
        tournament.setId(1L);
        assertEquals(1L, tournament.getId());
    }

    @Test
    void testNameField() {
        
        tournament.setName("Esslingen");
        assertEquals("Esslingen", tournament.getName());

       
        tournament.setName(null);
        assertNull(tournament.getName());
    }

    @Test
    void testDateField() {
        
        Date date = new Date();
        tournament.setDate(date);
        assertEquals(date, tournament.getDate());

       
        tournament.setDate(null);
        assertNull(tournament.getDate());
    }
}
