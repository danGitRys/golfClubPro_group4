package de.hse.golfclubmanagement.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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


    /*
     * Additional Tests with mocking the class to test with verify if the methods actually got called
     */

    @Test
    void testIdFieldWithMocks() {
    
        Tournament tournamentMock = Mockito.mock(Tournament.class);

        tournamentMock.setId(1L);
        when(tournamentMock.getId()).thenReturn(1L);

        assertEquals(1L, tournamentMock.getId());

        verify(tournamentMock, times(1)).setId(1L);
        verify(tournamentMock, times(1)).getId();
    }

    @Test
    void testNameFieldWithMocks() {
    
        Tournament tournamentMock = Mockito.mock(Tournament.class);

        tournamentMock.setName("Esslingen Open");
        when(tournamentMock.getName()).thenReturn("Esslingen Open");

        assertEquals("Esslingen Open", tournamentMock.getName());

        verify(tournamentMock, times(1)).setName("Esslingen Open");
        verify(tournamentMock, times(1)).getName();
    }

    @Test
    void testDateFieldWithMocks() {
       
        Date date = new Date();
        Tournament tournamentMock = Mockito.mock(Tournament.class);

        tournamentMock.setDate(date);
        when(tournamentMock.getDate()).thenReturn(date);

        assertEquals(date, tournamentMock.getDate());

        verify(tournamentMock, times(1)).setDate(date);
        verify(tournamentMock, times(1)).getDate();
    }
}
