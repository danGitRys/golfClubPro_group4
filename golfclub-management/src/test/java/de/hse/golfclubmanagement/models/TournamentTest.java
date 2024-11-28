package de.hse.golfclubmanagement.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TournamentTest {

    private Tournament tournament;

    @BeforeEach
    void setUp() {
        tournament = new Tournament();
    }



    /*
     * Testing if the id Field works like Excepected
     */
    @Test
    void testIdField() {
        //Testing with valid Id
        tournament.setId(1L);
        assertEquals(1L, tournament.getId());
        //Testing with null value
        tournament.setId(null);
        assertEquals(null, tournament.getId());
    }


    /*
     * Testing if the name Field works like Excepected
     */
    @Test
    void testNameField() {
        //Testing with valid Name
        tournament.setName("Esslingen");
        assertEquals("Esslingen", tournament.getName());
        // Testing with null as name
        tournament.setName(null);
        assertNull(tournament.getName());
        //Testing with empty string as tournament name
        tournament.setName("");
        assertEquals("", tournament.getName());
        
    }


    /*
     * Testing date the id Field works like Excepected
     */
    @Test
    void testDateField() {
        //testing with current date
        Date date = new Date();
        tournament.setDate(date);
        assertEquals(date, tournament.getDate());
        //testing with null as date
        tournament.setDate(null);
        assertNull(tournament.getDate());
        //testing with date in the past
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -10);
        Date pastDate = calendar.getTime();
        tournament.setDate(pastDate);
        assertEquals(pastDate, tournament.getDate());
    }


    /*
     * Additional Tests with mocking the class to test with verify if the methods actually got called
     */

    @Test
    void testIdFieldWithMocks() {
    
        Tournament tournamentMock = Mockito.mock(Tournament.class);

        tournamentMock.setId(1L);
        when(tournamentMock.getId()).thenReturn(1L);
        //asserting that values are equal
        assertEquals(1L, tournamentMock.getId());
        //checking that functions got called like expected
        verify(tournamentMock, times(1)).setId(1L);
        verify(tournamentMock, times(1)).getId();
    }

    @Test
    void testNameFieldWithMocks() {
    
        Tournament tournamentMock = Mockito.mock(Tournament.class);

        tournamentMock.setName("Esslingen Open");
        when(tournamentMock.getName()).thenReturn("Esslingen Open");
        //asserting that values are equal
        assertEquals("Esslingen Open", tournamentMock.getName());
        //checking that functions got called like expected
        verify(tournamentMock, times(1)).setName("Esslingen Open");
        verify(tournamentMock, times(1)).getName();
    }

    @Test
    void testDateFieldWithMocks() {
       
        Date date = new Date();
        Tournament tournamentMock = Mockito.mock(Tournament.class);

        tournamentMock.setDate(date);
        when(tournamentMock.getDate()).thenReturn(date);
        //asserting that values are equal
        assertEquals(date, tournamentMock.getDate());
        //checking that functions got called like expected
        verify(tournamentMock, times(1)).setDate(date);
        verify(tournamentMock, times(1)).getDate();
    }
}
