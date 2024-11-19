package de.hse.golfclubmanagement.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class TournamentTest {
    @Test
    void testGetDate() {
        Date date = new Date();
        Tournament tournament = new Tournament();
        tournament.setDate(date);
        assertEquals(date, tournament.getDate());


    }

    @Test
    void testGetId() {
        Tournament tournament = new Tournament();
        tournament.setId(1L);
        assertEquals(1L, tournament.getId());
    }

    @Test
    void testGetName() {
        Tournament tournament = new Tournament();
        tournament.setName("Esslingen");
        assertEquals("Esslingen", tournament.getName());

    }

    @Test
    void testSetDate() {
        Tournament tournament = new Tournament();
        Date date = new Date();
        tournament.setDate(date);
        assertEquals(date, tournament.getDate());

    }

    @Test
    void testSetId() {
        Tournament tournament = new Tournament();
        tournament.setId(1L);
        assertEquals(1L, tournament.getId());
    }

    @Test
    void testSetName() {
        Tournament tournament = new Tournament();
        tournament.setName("Esslingen");
        assertEquals("Esslingen", tournament.getName());

    }
}
